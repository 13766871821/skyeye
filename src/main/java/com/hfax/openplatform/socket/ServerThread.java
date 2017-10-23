package com.hfax.openplatform.socket;

/**
 * Created by SuPhoebe on 2015/12/27.
 * 服务器线程处理类
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.hfax.openplatform.db.LTMapper;

public class ServerThread extends Thread {

	private final Logger log = LoggerFactory.getLogger(getClass());

	// 和本线程相关的Socket
	private Socket socket = null;

	private LTMapper lTMapper;

	public ServerThread(Socket socket, LTMapper lTMapper) {
		this.socket = socket;
		this.lTMapper = lTMapper;
	}

	@Override
	public void run() {// 线程执行的操作，响应客户端的请求
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			// 获取输入流，并读取客户端信息
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String info = null;
			Boolean b = false;
			while ((info = br.readLine()) != null) {// 循环读取客户端的信息
				log.debug("我是服务器，客户端=" + info);
				@SuppressWarnings("unchecked")
				Map<String, String> inputMap = JSON.parseObject(info, Map.class);
				log.debug("我是服务器，客户端inputMap=" + inputMap);
				if ((inputMap != null) && (inputMap.size() > 0)) {
					b = insert_ltinfo(inputMap);
				}
			}
			socket.shutdownInput();// 关闭输入流
			os = socket.getOutputStream();// 获取输出流，响应客户端的请求
			pw = new PrintWriter(os);
			if (b) {
				pw.write("数据写入成功！");
			} else {
				pw.write("数据写入异常！");
			}
			pw.flush();// 调用flush()方法将缓冲输出
		} catch (Exception e) {
			log.error("IOException error:", e);
			if (pw != null) {
				pw.write("数据写入异常！");
			}
		} finally {
			// 关闭资源
			try {
				if (pw != null)
					pw.close();
				if (os != null)
					os.close();
				if (br != null)
					br.close();
				if (isr != null)
					isr.close();
				if (is != null)
					is.close();
				if (socket != null)
					socket.close();
			} catch (Exception e) {
				log.error("IOException error:", e);
				if (pw != null) {
					pw.write("数据写入异常！");
				}
			}
		}
	}

	public Boolean insert_ltinfo(Map<String, String> inputMap) {
		Boolean b = false;
		try {
			log.info("读取数据，插入数据库start...");
			Boolean i = lTMapper.insert_pubinfo(inputMap.get("deviceid"), inputMap.get("timestamp"), inputMap.get("devname"), inputMap.get("type"), inputMap.get("cmd"), inputMap.get("msgid"), inputMap.get("datatype"), inputMap.get("usr"), inputMap.get("pwd"));
			if (i) {
				log.info("-------------->insert_pubinfo suc");
				b = i;
			}
			@SuppressWarnings("unchecked")
			Map<String, String> dataMap = JSON.parseObject(JSON.toJSON(inputMap.get("data")).toString(), Map.class);
			Boolean ii = lTMapper.insert_gen_detail(dataMap.get("prs1"), dataMap.get("temp1"), dataMap.get("lev1"));
			if (ii) {
				log.info("-------------->insert_gen_detail suc");
				b = ii;
			}
			log.info("读取数据，插入数据库 end...");
		} catch (Exception e) {
			log.error("insert_ltinfo error:", e);
		}
		return b;
	}
}
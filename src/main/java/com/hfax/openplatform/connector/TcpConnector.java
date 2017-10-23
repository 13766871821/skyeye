package com.hfax.openplatform.connector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TcpConnector implements Connector {

	private int timeout;

	private Integer FS_TIMEOUT;
	private String FS_URL;
	private Integer FS_PORT;

	public TcpConnector() {
		super();
	}

	public TcpConnector(int timeout) {
		super();
		this.timeout = timeout;
	}

	private static Log logger = LogFactory.getLog(TcpConnector.class);

	@Override
	public String sendAndReceive(String pRequest) throws ConnectorException {

		byte[] byteStr = null;
		try {
			byteStr = pRequest.getBytes("GBK");
		} catch (UnsupportedEncodingException e1) {
			TcpConnector.logger.error("getBytes error:", e1);
			return "getBytes error";
		}

		Socket sock = null;
		OutputStream os = null;
		InputStream inputStream = null;
		try {

			sock = getSocket();
			os = sock.getOutputStream();// 发送数据
			os.write(byteStr);
			os.flush();

			inputStream = sock.getInputStream();// 接收数据

			byte[] readByte = TCPSocketUtil.readStream(inputStream);
			String recvBodyMsg = new String(readByte, "GBK");
			return recvBodyMsg;
		} catch (UnknownHostException e) {
			throw new ConnectorException("HOST无法识别", e);
		} catch (SocketTimeoutException e) {
			throw new ConnectorException("SocketTimeoutException", e);
		} catch (IOException e) {
			throw new ConnectorException("IO出现异常", e);
		} catch (Exception e) {
			throw new ConnectorException("出现异常", e);
		} finally {
			try {
				if (os != null) {
					os.flush();
				}
				if (inputStream != null) {
					inputStream.close();
				}
				if (sock != null) {
					sock.close();
				}
			} catch (IOException e) {
				throw new ConnectorException("＊＊＊＊＊＊＊＊＊＊＊ 无法关闭SOCKET或STREAM", e);
			}
		}
	}

	public Socket getSocket() throws UnknownHostException, IOException {
		Socket socket = new Socket();
		socket.connect(new InetSocketAddress(FS_URL, FS_PORT));
		if (timeout == 0) {
			socket.setSoTimeout(FS_TIMEOUT);
		} else {
			socket.setSoTimeout(timeout);
		}
		// read()阻塞超时时间5秒
		socket.setReceiveBufferSize(40980);
		socket.setTcpNoDelay(true);// 关闭Nagle算法.立即发包
		return socket;
	}

	public Integer getFS_PORT() {
		return FS_PORT;
	}

	public void setFS_PORT(Integer fS_PORT) {
		FS_PORT = fS_PORT;
	}

	public String getFS_URL() {
		return FS_URL;
	}

	public void setFS_URL(String fS_URL) {
		FS_URL = fS_URL;
	}

	public Integer getFS_TIMEOUT() {
		return FS_TIMEOUT;
	}

	public void setFS_TIMEOUT(Integer fS_TIMEOUT) {
		FS_TIMEOUT = fS_TIMEOUT;
	}

}

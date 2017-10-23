package com.hfax.openplatform.socket;

/**
 * 基于TCP协议的Socket通信，实现用户登陆
 * 服务器端
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hfax.openplatform.db.LTMapper;

@Component
@EnableScheduling
public class SocketServer {

	@Autowired
	private LTMapper lTMapper;

	/**
	 * 启动socket服务器
	 */
	@Scheduled(fixedDelay = 5000)
	public void startScheduled() {
		ServerSocket serverSocket = null;
		try {
			// 1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
			serverSocket = new ServerSocket(8888);
			Socket socket = null;
			// 记录客户端的数量
			int count = 0;
			System.out.println("***服务器即将启动，等待客户端的连接***");
			// 循环监听等待客户端的连接
			while (true) {
				// 调用accept()方法开始监听，等待客户端的连接
				socket = serverSocket.accept();
				// 创建一个新的线程
				ServerThread serverThread = new ServerThread(socket, lTMapper);
				// 启动线程
				serverThread.start();

				count++;// 统计客户端的数量
				System.out.println("客户端的数量：" + count);
				SocketAddress address = socket.getRemoteSocketAddress();
				System.out.println("当前客户端的IP：" + address.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				if (serverSocket != null) {
					serverSocket.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
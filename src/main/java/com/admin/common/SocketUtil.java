package com.admin.common;

import java.net.ServerSocket;
import java.net.Socket;
import com.admin.util.BasicData;
import com.admin.util.SocketRead;
import com.admin.util.SocketWrite;
import com.admin.util.Tool;

public class SocketUtil extends Thread {

	@Override
	public void run() {
		try {
			// 创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("***服务器即将启动，等待客户端的连接***");
			while (true) {// 循环监听等待客户端的连接
				Socket socket = serverSocket.accept();// 调用accept()方法开始监听，等待客户端的连接
				String key = Tool.randomNum(9);
				BasicData.socketMap.put(key, "-1");
				new SocketRead(socket, key).start();
				Thread.sleep(1000 * 5);
				String value = BasicData.socketMap.get(key);
				while ("-1".equals(value)) {
					value = BasicData.socketMap.get(key);
				}
				BasicData.socketMap.remove(key);
				new SocketWrite(socket, value).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

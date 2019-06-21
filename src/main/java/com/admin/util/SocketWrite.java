package com.admin.util;

import java.io.PrintWriter;
import java.net.Socket;

public class SocketWrite extends Thread {

	private Socket socket = null;
	private PrintWriter pw = null;
	private String key = null;

	public SocketWrite(Socket socket, String key) throws Exception {
		this.socket = socket;
		this.key = key;
		pw = new PrintWriter(this.socket.getOutputStream());
	}

	@Override
	public void run() {
		while (true) {
			try {
				String value = BasicData.socketMap.get(this.key);
				if (null == value || "".equals(value)) {
					Thread.sleep(1000 * 3);
					System.out.println("没有需要发送的数据,进入三秒钟休眠期....");
				} else {
					System.out.println("远程调度参数--->" + value);
					pw.write(value);
					pw.flush();
					BasicData.socketMap.remove(this.key);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

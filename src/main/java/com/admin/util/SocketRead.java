package com.admin.util;

import java.io.*;
import java.net.Socket;

public class SocketRead extends Thread {

	private Socket socket = null;
	private BufferedReader br = null;
	private DataInputStream dInput = null;
	private PrintWriter pw = null;
	private String key;

	public SocketRead(Socket socket, String key) throws Exception {
		this.socket = socket;
		this.key = key;
		br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		dInput = new DataInputStream(this.socket.getInputStream());
		pw = new PrintWriter(this.socket.getOutputStream());
	}

	@Override
	public void run() {
		try {
			String info = null;
			byte[] data = new byte[512];


			while ((info = br.readLine()) != null) {
				if ("-1".equals(BasicData.socketMap.get(key))) {
					String value = info.substring(0, 4);
					System.out.println("设备标识--->" + value);

					BasicData.socketMap.put(key, value);
				}
				System.out.println("我是服务器，客户端说：" + info);
				pw.write("success");
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

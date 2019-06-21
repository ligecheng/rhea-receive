package com.admin.common;

import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

@Component
@ServerEndpoint("/")
public class WebSocketServer {

	private static ConcurrentHashMap<String, WebSocketServer> websocketMap = new ConcurrentHashMap<String, WebSocketServer>();
	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;

	@OnOpen // 连接建立成功调用的方法
	public void onOpen(Session session) throws Exception {
		this.session = session;
		sendMessage("连接成功");
	}

	@OnMessage // 收到客户端消息后调用的方法
	public void onMessage(Session session, String message) throws Exception {
		System.out.println("收到客户端消息--->" + message);
		this.session.getBasicRemote().sendText("success");
	}

	/**
	 * 
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable t) {
		t.printStackTrace();
	}

	/**
	 * 实现服务器主动推送
	 */
	public void sendMessage(String message) throws Exception {
		this.session.getBasicRemote().sendText(message);
	}

}

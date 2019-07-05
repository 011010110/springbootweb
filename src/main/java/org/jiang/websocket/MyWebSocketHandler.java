package org.jiang.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;

/**
 * @author Li.Linhua
 * @description websocket
 * @Date 2019/5/28
 */
public class MyWebSocketHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String text = new String(message.asBytes());
        System.out.println("receive message:"+text);
        Map<String, Object> attributes = session.getAttributes();
        System.out.println(attributes);
        session.sendMessage(new TextMessage("hello I'm receive message"+text));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("webSocket connection Established");
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("webSocket TransportError");
    }
}

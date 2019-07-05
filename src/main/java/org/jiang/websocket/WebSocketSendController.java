package org.jiang.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import java.io.UnsupportedEncodingException;

/**
 * @author Li.Linhua
 * @description TODO
 * @Date 2019/5/28
 */
@Controller
@RequestMapping("/websocket")
public class WebSocketSendController {

    /*@Autowired
    SimpMessagingTemplate simpMessagingTemplate;*/

    @RequestMapping("/send")
    @ResponseBody
    public void sendMessage(String msg) throws UnsupportedEncodingException {
        System.out.println("要发送的消息："+msg);
//        simpMessagingTemplate.convertAndSend("/topic/subscribeTest",msg);
    }
}

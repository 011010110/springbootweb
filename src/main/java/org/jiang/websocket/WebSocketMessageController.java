package org.jiang.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

/**
 * @author Li.Linhua
 * @description TODO
 * @Date 2019/5/28
 */
@Controller
public class WebSocketMessageController {

    @MessageMapping("/test")
    public String handleMessage(String message){
        System.out.println("handleMessage收到消息："+message);
        return "I'm received,"+message;
    }

    @SubscribeMapping("/subscribeTest")
    public String subscriptionMessage(String message){
        System.out.println("收到订阅请求："+message);
        return "收到订阅请求";
    }
}

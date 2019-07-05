package org.jiang.aop.AspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;
import java.util.List;

/**
 * @author Li.Linhua
 * @description TODO
 * @Date 2019/5/26
 */
@Aspect
public class PlayerPreHotAspectJ {

    ThreadLocal threadLocal = new ThreadLocal();
    @Before("execution(* play(..))")
    public void preHot(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        List<Object> objects = Arrays.asList(args);
        System.out.println("prehoting 方法签名："+signature+";入参:"+objects.toString());
    }

    /**
     * @description When using the WebSocketHandler API directly vs indirectly,
     * e.g. through the STOMP messaging, the application must synchronize the
     * sending of messages since the underlying standard WebSocket session (JSR-356)
     * does not allow concurrent sending.
     * @param name
     * @param ff
     * @param bb
     * @return
     * @author Li.Linhua
     * @date 2019/5/28
     */
    @Before("args(name,ff,bb)")
    public void statistic(String name,int ff,int bb){
        System.out.println("比赛统计：name="+name+";ff="+ff+";bb="+bb);
    }
}

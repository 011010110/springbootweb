package org.jiang;

import org.jiang.aop.AspectJ.BaseketBoolPlayer;
import org.jiang.aop.AspectJ.Player;
import org.jiang.aop.AspectJ.PlayerPreHotAspectJ;
import org.jiang.aop.SimpleWriter;
import org.jiang.aop.WriterAdvice;
import org.junit.Test;
import org.springframework.aop.aspectj.AspectJPointcutAdvisor;
import org.springframework.aop.aspectj.annotation.AspectJAdvisorFactory;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author Li.Linhua
 * @description TODO
 * @Date 2019/5/25
 */
public class AOPTest {

    @Test
    public void writerAopTest(){
        ProxyFactory proxyFactory = new ProxyFactory();
        SimpleWriter simpleWriter = new SimpleWriter();
        WriterAdvice writerAdvice = new WriterAdvice();
        proxyFactory.setTarget(simpleWriter);
        proxyFactory.addAdvice(writerAdvice);
        SimpleWriter proxy = (SimpleWriter) proxyFactory.getProxy();
        proxy.hello("小明");
    }

    @Test
    public void AspectJTest(){
        Player player = new BaseketBoolPlayer();
        PlayerPreHotAspectJ aspectJ = new PlayerPreHotAspectJ();
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory();
        aspectJProxyFactory.setTarget(player);
        aspectJProxyFactory.addAspect(aspectJ);
        Player proxy = aspectJProxyFactory.getProxy();
        proxy.play("2019-05-26");
    }

    @Test
    public void AspectJMethodTest(){
        BaseketBoolPlayer player = new BaseketBoolPlayer();
        PlayerPreHotAspectJ aspectJ = new PlayerPreHotAspectJ();
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory();
        aspectJProxyFactory.setTarget(player);
        aspectJProxyFactory.addAspect(aspectJ);
        BaseketBoolPlayer proxy = aspectJProxyFactory.getProxy();
        proxy.statisticData("卡哇伊",66,20);
        proxy.statisticData2("字母哥",77);
    }
}

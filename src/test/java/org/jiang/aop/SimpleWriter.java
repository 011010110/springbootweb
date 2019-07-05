package org.jiang.aop;

/**
 * @author Li.Linhua
 * @description TODO
 * @Date 2019/5/25
 */
public class SimpleWriter implements Writer {
    @Override
    public void hello(String name) {
        System.out.println("hello "+name);
    }
}

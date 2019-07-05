package org.jiang.aop.AspectJ;

/**
 * @author Li.Linhua
 * @description TODO
 * @Date 2019/5/26
 */
public class BaseketBoolPlayer implements Player{
    @Override
    public void play(String time) {
        System.out.println("play baseketbool:"+time+" minute");
    }

    public void statisticData(String name,int defen,int bounds){
        System.out.println("球员："+name+";得分："+defen+";篮板："+bounds);
    }

    public void statisticData2(String name,int defen){
        System.out.println("球员："+name+";得分："+defen+";篮板：没有篮板");
    }
}

package org.jiang.demo.domain;

/**
 * @author 12572
 * @ Date 2018/9/23 9:53
 */
public class Dog {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}

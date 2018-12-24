package org.jiang.demo.controller;

import org.jiang.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author 12572
 * @ Date 2018/9/18 13:18
 */
@Controller
@RequestMapping("/home")
public class HelloController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(String name){
        System.out.println(name);
        String idName = demoService.getName(name);
        return "hello "+idName;
    }

    @RequestMapping("/index")
    public String index(Map<String,String> map){
        map.put("name","boot");
        return "index";
    }
}

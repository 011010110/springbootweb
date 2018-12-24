package org.jiang.demo.service;

import org.springframework.stereotype.Service;

/**
 * @author 12572
 * @ Date 2018/9/19 12:56
 */
@Service
public class DemoService {

    public String getName(String id){
        return "name"+id;
    }
}

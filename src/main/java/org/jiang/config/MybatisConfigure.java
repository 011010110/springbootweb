package org.jiang.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Li.Linhua
 * @description TODO
 * @Date 2019/4/27 22:26
 */
@Configuration
@MapperScan("org.jiang.mapper")
public class MybatisConfigure {

}

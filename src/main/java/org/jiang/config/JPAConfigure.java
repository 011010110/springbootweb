package org.jiang.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Li.Linhua
 * @description 开启jpa配置
 * @Date 2019/4/27 13:01
 */
@EnableJpaRepositories(basePackages = "org.jiang.dao")
@EntityScan(basePackages = "org.jiang.domain")
@Configuration
public class JPAConfigure {
}

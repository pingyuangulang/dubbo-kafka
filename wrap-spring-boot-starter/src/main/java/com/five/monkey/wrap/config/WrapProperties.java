package com.five.monkey.wrap.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置文件内容类
 *
 * 前缀属性:jim.wrap.prefix
 * 后缀属性:jim.wrap.suffix
 *
 * @author jim
 * @date 2020/6/24 21:21
 */
@Data
@ConfigurationProperties(prefix = "jim.wrap")
public class WrapProperties {

    private String prefix = "I\'m prefix ";

    private String suffix = " I\'m suffix";

    private boolean enable = true;
}

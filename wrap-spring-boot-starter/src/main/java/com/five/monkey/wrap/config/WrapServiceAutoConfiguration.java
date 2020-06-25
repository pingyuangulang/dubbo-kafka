package com.five.monkey.wrap.config;

import com.five.monkey.wrap.service.WrapService;
import com.five.monkey.wrap.service.impl.DefaultWrapServiceImpl;
import com.five.monkey.wrap.service.impl.WrapServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * WrapService的自动配置类
 *
 * @author jim
 * @date 2020/6/24 21:17
 */
@Configuration
@ConditionalOnClass(value = {WrapService.class, WrapServiceImpl.class})
@EnableConfigurationProperties(value = {WrapProperties.class})
public class WrapServiceAutoConfiguration {

    @Autowired
    private WrapProperties wrapProperties;

    /**
    @Bean
    @ConditionalOnMissingBean
    public WrapService wrapService() {
        WrapService wrapService;
        if (wrapProperties.isEnable()) {
            wrapService = new WrapServiceImpl(wrapProperties.getPrefix(), wrapProperties.getSuffix());
        } else {
            wrapService = new WrapServiceImpl(StringUtils.EMPTY, StringUtils.EMPTY);
        }
        return wrapService;
    }
    */

    @Bean
    @ConditionalOnProperty(name = "jim.wrap.enable", matchIfMissing = true)
    public WrapService wrapService() {
        return new WrapServiceImpl(wrapProperties.getPrefix(), wrapProperties.getSuffix());
    }

    @Bean
    @ConditionalOnMissingBean(value = {WrapService.class})
    public WrapService defaultWrapService() {
        return new DefaultWrapServiceImpl();
    }
}

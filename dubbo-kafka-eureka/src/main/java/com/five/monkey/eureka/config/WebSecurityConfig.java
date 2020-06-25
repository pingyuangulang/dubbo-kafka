//package com.five.monkey.eureka.config;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    /**
//     * Spring Boot 2.0 以上的security默认启用了csrf检验，要在eurekaServer端配置security的csrf检验为false
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        super.configure(http);
//    }
//}

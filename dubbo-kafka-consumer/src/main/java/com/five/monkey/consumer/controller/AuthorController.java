package com.five.monkey.consumer.controller;

import com.five.monkey.bo.AuthorBo;
import com.five.monkey.consumer.dubbo.ConsumeAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 *
 * @author jim
 * @date 2020/5/8 15:32
 */
@RestController
@RequestMapping("/consume/author")
public class AuthorController {

    private final String SERVICE_PROVIDER = "http://dubbo-kafka-provider";

    @Autowired
    private ConsumeAuthorService authorService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}/getInfo/by/dubbo")
    public AuthorBo getInfo(@PathVariable("id") Long id) {
        return authorService.findById(id);
    }

    @GetMapping("/{id}/getInfo/by/rest")
    public AuthorBo getInfoByRest(@PathVariable("id") Long id) {
        String interface_uri = "/author/{id}/getInfo";
        return restTemplate.getForEntity(SERVICE_PROVIDER + interface_uri, AuthorBo.class, id).getBody();
    }
}

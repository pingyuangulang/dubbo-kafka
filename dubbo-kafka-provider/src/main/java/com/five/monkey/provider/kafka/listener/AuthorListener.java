package com.five.monkey.provider.kafka.listener;

import com.five.monkey.api.AuthorService;
import com.five.monkey.bo.AuthorBo;
import com.five.monkey.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author jim
 * @date 2020/5/8 15:57
 */
@Component
public class AuthorListener {

    @Autowired
    @Qualifier("authorServiceImpl")
    private AuthorService authorService;

    @KafkaListener(topics = {"${kafka.topic.author}"}, groupId = "${spring.kafka.consumer.group-id}")
    public void listener(String data) {
        if (StringUtils.isBlank(data)) {
            return;
        }
        AuthorBo authorBo = JsonUtil.parse(data, AuthorBo.class);
        authorService.save(authorBo);
    }
}

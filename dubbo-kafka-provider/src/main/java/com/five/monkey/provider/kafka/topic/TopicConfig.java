package com.five.monkey.provider.kafka.topic;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author jim
 * @date 2020/5/8 17:25
 */
@Component
public class TopicConfig {

    @Getter
    @Value("${kafka.topic.author:author}")
    private String authorTopic;

    @Getter
    @Value("${kafka.topic.book:book}")
    private String bookTopic;
}

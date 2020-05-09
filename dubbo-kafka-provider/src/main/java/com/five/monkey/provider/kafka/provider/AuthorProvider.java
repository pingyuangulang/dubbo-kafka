package com.five.monkey.provider.kafka.provider;

import com.five.monkey.bo.AuthorBo;
import com.five.monkey.provider.kafka.topic.TopicConfig;
import com.five.monkey.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Objects;

/**
 *
 *
 * @author jim
 * @date 2020/5/8 15:57
 */
@Component
public class AuthorProvider {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    @Autowired
    private TopicConfig topicConfig;

    public boolean send(AuthorBo authorBo) {
        if (Objects.isNull(authorBo)) {
            throw new IllegalArgumentException("kafka send null message is disable");
        }
        String data = JsonUtil.toJson(authorBo);
        ListenableFuture<SendResult<Integer, String>> sendResult = kafkaTemplate.send(topicConfig.getAuthorTopic(), data);
        return sendResult.isDone();
    }
}

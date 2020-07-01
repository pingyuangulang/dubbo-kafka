package com.five.monkey.provider.service;

import com.five.monkey.provider.annotation.RedisCache;
import com.five.monkey.api.AuthorService;
import com.five.monkey.bo.AuthorBo;
import com.five.monkey.provider.contains.KeyContains;
import com.five.monkey.mapper.extend.AuthorExtendMapper;
import com.five.monkey.model.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author jim
 * @date 2020/4/29 18:27
 */
@Service("authorServiceImpl")
@Slf4j
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorExtendMapper authorExtendMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 根据作者id查询作者信息
     *
     * @param authorId
     * @return
     */
    @Override
    @RedisCache(key = KeyContains.Author.AUTHOR_INFO, expire = 1L, timeUnit = TimeUnit.DAYS)
    public AuthorBo findById(Long authorId) {
        Author author = authorExtendMapper.selectByPrimaryKey(authorId);
        AuthorBo authorBo = null;
        if (Objects.nonNull(author)) {
            authorBo = new AuthorBo();
            BeanUtils.copyProperties(author, authorBo);
        }
        return authorBo;
    }

    /**
     * 插入或修改
     *
     * @param authorBo
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public AuthorBo save(AuthorBo authorBo) {
        if (Objects.isNull(authorBo)) {
            return null;
        }

        Author author = new Author();
        BeanUtils.copyProperties(authorBo, author);

        if (Objects.nonNull(authorBo.getId()) && authorBo.getId().compareTo(0L) > 0) {
            authorExtendMapper.updateByPrimaryKey(author);
        } else {
            authorExtendMapper.insertSelective(author);
            authorBo.setId(author.getId());
        }
        return authorBo;
    }
}

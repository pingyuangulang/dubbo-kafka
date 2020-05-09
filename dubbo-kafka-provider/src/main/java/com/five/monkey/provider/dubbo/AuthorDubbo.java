package com.five.monkey.provider.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.five.monkey.api.AuthorService;
import com.five.monkey.bo.AuthorBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 *
 * @author jim
 * @date 2020/4/29 19:22
 */
@Service(interfaceClass = AuthorService.class, timeout = 3000)
public class AuthorDubbo implements AuthorService {

    @Autowired
    @Qualifier("authorServiceImpl")
    private AuthorService authorService;

    /**
     * 根据作者id查询作者信息
     *
     * @param authorId
     * @return
     */
    @Override
    public AuthorBo findById(Long authorId) {
        return authorService.findById(authorId);
    }

    /**
     * 插入或修改
     *
     * @param authorBo
     * @return
     */
    @Override
    public AuthorBo save(AuthorBo authorBo) {
        return authorService.save(authorBo);
    }
}

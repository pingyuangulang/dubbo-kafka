package com.five.monkey.api;

import com.five.monkey.bo.AuthorBo;

/**
 *
 *
 * @author jim
 * @date 2020/4/29 18:14
 */
public interface AuthorService {

    /**
     * 根据作者id查询作者信息
     *
     * @param authorId
     * @return
     */
    AuthorBo findById(Long authorId);

    /**
     * 插入或修改
     *
     * @param authorBo
     * @return
     */
    AuthorBo save(AuthorBo authorBo);
}

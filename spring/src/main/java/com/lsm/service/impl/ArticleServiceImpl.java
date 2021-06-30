package com.lsm.service.impl;

import com.lsm.mapper.ArticleMapper;
import com.lsm.pojo.Article;
import com.lsm.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public void saveArticle(Article article) {
        articleMapper.saveArticle(article);
        // 事务回滚
        // int i = 1 / 0;
    }
}

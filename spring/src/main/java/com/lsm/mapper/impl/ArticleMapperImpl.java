package com.lsm.mapper.impl;

import com.lsm.mapper.ArticleMapper;
import com.lsm.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleMapperImpl implements ArticleMapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveArticle(Article article) {
        String sql = "insert into t_article(title,content) values(?,?)";
        jdbcTemplate.update(sql,article.getTitle(),article.getContent());
    }
}

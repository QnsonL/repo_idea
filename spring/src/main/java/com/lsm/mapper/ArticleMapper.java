package com.lsm.mapper;

import com.lsm.pojo.Article;

public interface ArticleMapper {
    // 添加文章信息
    void saveArticle(Article article);
}

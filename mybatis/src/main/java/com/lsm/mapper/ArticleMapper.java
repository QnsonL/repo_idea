package com.lsm.mapper;

import com.lsm.pojo.Article;

import java.util.List;

public interface ArticleMapper {
    // 进行全部信息查询
    List<Article> queryAllWithComment();
}

package com.lsm.mapper;

import com.lsm.pojo.Comment;

import java.util.List;

public interface CommentMapper {
    List<Comment> queryByAId(int aId);
}

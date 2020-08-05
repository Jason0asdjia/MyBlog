package com.jason.service;

import com.jason.po.Comment;

import java.util.List;

/**
 * @author Jason
 * @date 8/5/2020 7:24 PM
 */
public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}

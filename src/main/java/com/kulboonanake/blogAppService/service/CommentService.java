package com.kulboonanake.blogAppService.service;

import com.kulboonanake.blogAppService.payload.CommentDto;

import java.util.List;


public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
    List<CommentDto> getCommentByPostId(long postId);
    CommentDto getCommentById(long postId, long id);
    CommentDto updateCommentById(CommentDto commentDto, long postId, long id);
    void deleteCommentById(long postId, long id);
}

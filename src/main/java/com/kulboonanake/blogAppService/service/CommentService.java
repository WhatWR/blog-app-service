package com.kulboonanake.blogAppService.service;

import com.kulboonanake.blogAppService.payload.CommentDto;
import com.kulboonanake.blogAppService.payload.PostDto;
import com.kulboonanake.blogAppService.payload.PostResponse;


public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
    void getAllComments(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getCommentById(long id);
    PostDto updateComment(CommentDto commentDto, long id);
    void DeleteCommentById(long id);
}

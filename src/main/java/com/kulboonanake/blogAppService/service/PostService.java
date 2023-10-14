package com.kulboonanake.blogAppService.service;

import com.kulboonanake.blogAppService.payload.PostDto;
import com.kulboonanake.blogAppService.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);
    void DeletePostById(long id);
}

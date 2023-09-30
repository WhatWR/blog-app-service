package com.kulboonanake.blogAppService.service;

import com.kulboonanake.blogAppService.payload.PostDto;
import com.kulboonanake.blogAppService.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy);
    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void DeletePostById(long id);
}

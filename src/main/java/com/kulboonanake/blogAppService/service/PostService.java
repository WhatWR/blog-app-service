package com.kulboonanake.blogAppService.service;

import com.kulboonanake.blogAppService.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts(int pageNo, int pageSize);
    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void DeletePostById(long id);
}

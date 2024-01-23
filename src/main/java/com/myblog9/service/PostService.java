package com.myblog9.service;

import com.myblog9.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto savePost(PostDto postDto);

    void deletePostById(Long id);

    PostDto getPostById(Long id);

    PostDto updatePost(long id, PostDto postDto);

    List<PostDto> getAllPosts(int pageNo, int pageSize);
}

package com.myblog.myblog.service;

import com.myblog.myblog.payload.PostDto;

import java.util.List;

public interface PostService {

    public PostDto createPost(PostDto postdto);

    PostDto getPostById(long id);

    List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
}

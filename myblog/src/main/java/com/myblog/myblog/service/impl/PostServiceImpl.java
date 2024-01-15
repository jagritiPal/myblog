package com.myblog.myblog.service.impl;

import com.myblog.myblog.entity.PostEntity;
import com.myblog.myblog.exception.ResourceNotFoundException;
import com.myblog.myblog.payload.PostDto;
import com.myblog.myblog.repository.PostRepository;
import com.myblog.myblog.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;

    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public PostDto createPost(PostDto postdto) {

        PostEntity postEnt = new PostEntity();
        postEnt.setTitle(postdto.getTitle());
        postEnt.setDescription(postdto.getDescription());
        postEnt.setContent(postdto.getContent());

        PostEntity savePost = postRepo.save(postEnt);

        PostDto dto = new PostDto();
        dto.setTitle(savePost.getTitle());
        dto.setDescription(savePost.getDescription());
        dto.setContent(savePost.getContent());

        return dto;
    }

    @Override
    public PostDto getPostById(long id) {
        PostEntity postEntity = postRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post not found with id:" +id)
        );

        PostDto dto = new PostDto();
        dto.setId(postEntity.getId());
        dto.setTitle(postEntity.getTitle());
        dto.setDescription(postEntity.getDescription());
        dto.setContent(postEntity.getContent());
        return dto;
    }
}

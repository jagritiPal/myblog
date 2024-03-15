package com.myblog.myblog.service.impl;

import com.myblog.myblog.entity.PostEntity;
import com.myblog.myblog.exception.ResourceNotFoundException;
import com.myblog.myblog.payload.PostDto;
import com.myblog.myblog.repository.PostRepository;
import com.myblog.myblog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;
    private ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postdto) {

        PostEntity postEnt = mapToEntity(postdto);
        PostEntity savePost = postRepo.save(postEnt);
        PostDto postDto = mapToDto(postEnt);
        return postDto;
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

    @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<PostEntity> postEntity = postRepo.findAll(pageable);
        List<PostEntity> post = postEntity.getContent();
        List<PostDto> dtos = postEntity.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return dtos;
    }

    PostDto mapToDto(PostEntity postEntity){
        PostDto dto = modelMapper.map(postEntity, PostDto.class);
//        PostDto dto = new PostDto();
//        dto.setId(postEntity.getId());
//        dto.setTitle(postEntity.getTitle());
//        dto.setDescription(postEntity.getDescription());
//        dto.setContent(postEntity.getContent());
        return dto;
    }

    PostEntity mapToEntity(PostDto postDto){
        PostEntity postEnt = modelMapper.map(postDto, PostEntity.class);
//        PostEntity postEnt = new PostEntity();
//        postEnt.setTitle(postDto.getTitle());
//        postEnt.setDescription(postDto.getDescription());
//        postEnt.setContent(postDto.getContent());
        return postEnt;
    }
}

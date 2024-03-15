package com.myblog.myblog.service.impl;

import com.myblog.myblog.entity.CommentEntity;
import com.myblog.myblog.entity.PostEntity;
import com.myblog.myblog.exception.ResourceNotFoundException;
import com.myblog.myblog.payload.CommentDto;
import com.myblog.myblog.repository.PostRepository;
import com.myblog.myblog.repository.CommentRepository;
import com.myblog.myblog.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private PostRepository postRepo;
    private CommentRepository commentRepo;
    private ModelMapper modelMapper;

    public CommentServiceImpl(PostRepository postRepo, CommentRepository commentRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, Long postId) {
        PostEntity post = postRepo.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post not found with this id:" + postId)
        );

        CommentEntity comment = new CommentEntity();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);

        CommentEntity savedComment = commentRepo.save(comment);

        CommentDto dto = new CommentDto();
        dto.setId(savedComment.getId());
        dto.setText(savedComment.getText());
        dto.setEmail(savedComment.getEmail());
        return dto;
    }

    @Override
    public void deleteComment(long id) {
        commentRepo.deleteById(id);

    }

    @Override
    public CommentDto updateComment(long id, CommentDto commentDto, long postId) {
        PostEntity postEntity = postRepo.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post not found for id:" + id)
        );
        CommentEntity comEnt = commentRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment not found for id:" + id)
        );
        CommentEntity comment = mapToEntity(commentDto);
        comment.setId(comEnt.getId());
        comment.setPost(postEntity);
        CommentEntity saveComment = commentRepo.save(comment);
        return mapToDto(saveComment) ;
    }

    CommentDto mapToDto(CommentEntity comEnt){
        CommentDto dto = modelMapper.map(comEnt, CommentDto.class);
        return dto;
    }

    CommentEntity mapToEntity(CommentDto commentDto){
        CommentEntity comEnt = modelMapper.map(commentDto, CommentEntity.class);
        return comEnt;
    }
}

package com.myblog.myblog.controller;

import com.myblog.myblog.entity.CommentEntity;
import com.myblog.myblog.payload.CommentDto;
import com.myblog.myblog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService comServ;

    public CommentController(CommentService comServ) {
        this.comServ = comServ;
    }

    //http://localhost:8080/api/comments?postId=1
    @PostMapping
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto commentDto,
            @RequestParam long postId
    ){
        CommentDto dto = comServ.createComment(commentDto, postId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/comments/2
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id){
        comServ.deleteComment(id);
        return new ResponseEntity<>("Comment is deleted!!", HttpStatus.OK);
    }

    //http://localhost:8080/api/comments/1/posts/1
    @PutMapping("/{id}/post/{postId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable long id, @RequestBody CommentDto commentDto, @PathVariable long postId){
        CommentDto dto = comServ.updateComment(id, commentDto, postId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}

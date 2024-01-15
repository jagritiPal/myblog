package com.myblog.myblog.Controller;

import com.myblog.myblog.payload.PostDto;
import com.myblog.myblog.service.PostService;
import com.myblog.myblog.service.impl.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postSer;

    public PostController(PostService postSer) {
        this.postSer = postSer;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postSer.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PostDto> getPostById(@RequestParam long id){
        PostDto dto = postSer.getPostById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


}

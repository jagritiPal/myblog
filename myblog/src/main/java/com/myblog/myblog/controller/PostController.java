package com.myblog.myblog.controller;

import com.myblog.myblog.payload.PostDto;
import com.myblog.myblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postSer;

    public PostController(PostService postSer) {
        this.postSer = postSer;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postSer.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/posts/particular?id=1
    @GetMapping("/particular")
    public ResponseEntity<PostDto> getPostById(@RequestParam long id){
        PostDto dto = postSer.getPostById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //http://localhost:8080/api/posts?pageNo=0&pageSize=1&sortBy=title&sortDir=dsc
    @GetMapping
    public List<PostDto> getAlllPosts(
            @RequestParam (name = "pageNo", required = false, defaultValue = "0") int pageNo,
            @RequestParam (name = "pageSize", required = false, defaultValue = "1") int pageSize,
            @RequestParam (name = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam (name = "sortDir", required = false, defaultValue = "id") String sortDir
    ){
        List<PostDto> postDtos = postSer.getAllPosts(pageNo, pageSize, sortBy, sortDir);
        return postDtos;
    }


}

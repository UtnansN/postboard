package com.social.postboard.controller;

import com.social.postboard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/communities/{communityTag}/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public void getPosts(Pageable pageable) {

    }

    @GetMapping("/{id}")
    private String getPost(@PathVariable String communityTag, @PathVariable String id) {
        return "Community: " + communityTag + " Id: " + id;
    }

}

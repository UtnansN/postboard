package com.social.postboard.controller;

import com.social.postboard.dto.FullPostDTO;
import com.social.postboard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/communities/{communityTag}/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public void getPosts(Pageable pageable) {

    }

    @PostMapping
    public void createPost() {

    }

    @GetMapping("/{id}")
    private FullPostDTO getPost(@PathVariable int id) {
        FullPostDTO post = postService.getPost((long) id);
        post.add(linkTo(methodOn(PostController.class).getPost(id)).withSelfRel());
        return post;
    }

}

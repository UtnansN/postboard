package com.social.postboard.controller;

import com.social.postboard.dto.CommentDTO;
import com.social.postboard.dto.FullPostDTO;
import com.social.postboard.dto.ShortPostDTO;
import com.social.postboard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/communities/{tag}/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    private FullPostDTO getPost(@PathVariable String tag, @PathVariable int id) {
        FullPostDTO post = postService.getPost((long) id);

        // FIXME: HATEOAS implementation
        //post.add(linkTo(methodOn(PostController.class).getPost(tag, id)).withSelfRel());
        return post;
    }

    @PostMapping
    public void createPost(@PathVariable String tag, @RequestBody ShortPostDTO postDTO) {
        postService.addPost(tag, postDTO);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable int id, @RequestBody ShortPostDTO postDTO) {
        postService.updatePost((long) id, postDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {
        postService.removePost((long) id);
    }

    @PostMapping("/{id}/comment")
    public void addComment(@PathVariable int id, @RequestBody CommentDTO commentDTO) {
        postService.addComment((long) id, commentDTO);
    }
}

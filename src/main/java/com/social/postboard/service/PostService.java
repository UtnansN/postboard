package com.social.postboard.service;

import com.social.postboard.dto.CommentDTO;
import com.social.postboard.dto.FullPostDTO;
import com.social.postboard.dto.ShortPostDTO;
import com.social.postboard.entity.Comment;
import com.social.postboard.entity.Community;
import com.social.postboard.entity.Post;
import com.social.postboard.entity.User;
import com.social.postboard.exception.ResourceNotFoundException;
import com.social.postboard.mapper.CommentMapper;
import com.social.postboard.mapper.PostMapper;
import com.social.postboard.repository.CommentRepository;
import com.social.postboard.repository.CommunityRepository;
import com.social.postboard.repository.PostRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {

    @Autowired
    private CommunityRepository communityRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    private final PostMapper postMapper = Mappers.getMapper(PostMapper.class);
    private final CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);

    public FullPostDTO getPost(Long id) {
        return postMapper.toFullPost(postRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<ShortPostDTO> getPostPage(String tag, Pageable pageable) {
        Page<Post> posts = postRepository.findAll(pageable);

        return null;
    }

    public void addPost(String tag, ShortPostDTO postDTO) {
        Community parentCommunity = communityRepository.findFirstByTag(tag)
                .orElseThrow(ResourceNotFoundException::new);
        Post post = postMapper.toPost(postDTO);

        post.setCreationDate(LocalDateTime.now());
        post.getUpVoters().add(new User());
        post.setCommunity(parentCommunity);
        postRepository.save(post);
    }

    public void addComment(Long postId, CommentDTO commentDTO) {

        Post parentPost = postRepository.findById(postId)
                .orElseThrow(ResourceNotFoundException::new);

        Comment comment = commentMapper.toComment(commentDTO);

        // FIXME: Add actual user that up-voted
        comment.getUpVoters().add(new User());
        comment.setCreationDate(LocalDateTime.now());
        comment.setPost(parentPost);
        commentRepository.save(comment);
    }

    public void updatePost() {

    }

    public void removePost(Long id) {
        postRepository.deleteById(id);
    }
}

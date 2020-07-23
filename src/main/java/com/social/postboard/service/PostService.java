package com.social.postboard.service;

import com.social.postboard.dto.FullPostDTO;
import com.social.postboard.exception.ResourceNotFoundException;
import com.social.postboard.mapper.PostMapper;
import com.social.postboard.repository.PostRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    private final PostMapper postMapper = Mappers.getMapper(PostMapper.class);

    public FullPostDTO getPost(Long id) {
        return postMapper.toFullPost(postRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }
}

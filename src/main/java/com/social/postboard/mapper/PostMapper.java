package com.social.postboard.mapper;

import com.social.postboard.dto.FullPostDTO;
import com.social.postboard.dto.ShortPostDTO;
import com.social.postboard.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface PostMapper {

    @Mapping(target = "upVotes", expression = "java((long) post.getUpVoters().size())")
    FullPostDTO toFullPost(Post post);

    Post toPost(ShortPostDTO postDTO);

    Post updatePost(ShortPostDTO postDTO, @MappingTarget Post post);
}

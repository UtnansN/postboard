package com.social.postboard.mapper;

import com.social.postboard.dto.FullPostDTO;
import com.social.postboard.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PostMapper {
    FullPostDTO toFullPost(Post post);
}

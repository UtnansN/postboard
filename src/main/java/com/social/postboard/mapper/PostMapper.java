package com.social.postboard.mapper;

import com.social.postboard.dto.FullPostDTO;
import com.social.postboard.entity.Post;
import org.mapstruct.Mapper;

@Mapper
public interface PostMapper {
    FullPostDTO toFullPost(Post post);
}

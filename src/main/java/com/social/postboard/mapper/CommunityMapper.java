package com.social.postboard.mapper;

import com.social.postboard.dto.CommunityPageDTO;
import com.social.postboard.entity.Community;
import org.mapstruct.Mapper;

@Mapper
public interface CommunityMapper {
    CommunityPageDTO toPageDTO(Community entity);
}

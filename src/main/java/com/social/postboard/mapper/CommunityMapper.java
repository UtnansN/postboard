package com.social.postboard.mapper;

import com.social.postboard.dto.CommunityDTO;
import com.social.postboard.dto.CommunityPageDTO;
import com.social.postboard.entity.Community;
import org.mapstruct.*;

@Mapper
public interface CommunityMapper {
    CommunityPageDTO toPageDTO(Community entity);

    @BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
    Community toCommunity(CommunityDTO communityDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Community toCommunity(CommunityDTO communityDTO, @MappingTarget Community community);

    @Mapping(target = "memberCount", expression = "java((long) community.getMembers().size())")
    CommunityDTO toCommunityDTO(Community community);
}

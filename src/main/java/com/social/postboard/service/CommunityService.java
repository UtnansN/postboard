package com.social.postboard.service;

import com.social.postboard.dto.CommunityPageDTO;
import com.social.postboard.entity.Community;
import com.social.postboard.exception.ResourceNotFoundException;
import com.social.postboard.mapper.CommunityMapper;
import com.social.postboard.repository.CommunityRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    private final CommunityMapper communityMapper = Mappers.getMapper(CommunityMapper.class);

    public void addCommunity(Community community) {
        communityRepository.save(community);
    }

    public void deleteCommunity(String cId) {
        communityRepository.deleteById(cId);
    }

    public CommunityPageDTO findCommunity(String cId) {
        Community community = communityRepository.findById(cId)
                .orElseThrow(ResourceNotFoundException::new);

        return communityMapper.toPageDTO(community);
    }
}

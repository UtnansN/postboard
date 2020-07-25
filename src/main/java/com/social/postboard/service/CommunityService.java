package com.social.postboard.service;

import com.social.postboard.dto.CommunityDTO;
import com.social.postboard.dto.CommunityPageDTO;
import com.social.postboard.entity.Community;
import com.social.postboard.exception.ResourceNotFoundException;
import com.social.postboard.mapper.CommunityMapper;
import com.social.postboard.repository.CommunityRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    private final CommunityMapper communityMapper = Mappers.getMapper(CommunityMapper.class);

    public Page<CommunityDTO> getCommunities(Pageable pageable) {
        return communityRepository.findAll(pageable)
                .map(communityMapper::toCommunityDTO);
    }

    public CommunityPageDTO findCommunity(String tag) {
        Community community = communityRepository.findFirstByTag(tag)
                .orElseThrow(ResourceNotFoundException::new);
        return communityMapper.toPageDTO(community);
    }

    public void addCommunity(CommunityDTO communityDTO) {
        Community community = communityMapper.toCommunity(communityDTO);
        community.setCreationDate(LocalDateTime.now());

        // TODO: Add creator as member with admin privileges
        //community.getMembers().add(null);
        communityRepository.save(community);
    }

    public void updateCommunity(String tag, CommunityDTO dto) {
        Community community = communityRepository.findFirstByTag(tag)
                .orElseThrow(ResourceNotFoundException::new);

        Community newCommunity = communityMapper.toCommunity(dto, community);
        communityRepository.save(newCommunity);
    }

    public void deleteCommunity(String tag) {
        communityRepository.deleteByTag(tag);
    }
}

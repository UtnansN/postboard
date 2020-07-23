package com.social.postboard.service;

import com.social.postboard.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    public void deleteCommunity(Long id) {
        communityRepository.deleteById(id);
    }

}

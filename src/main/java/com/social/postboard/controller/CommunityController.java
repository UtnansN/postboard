package com.social.postboard.controller;

import com.social.postboard.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/communities")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @GetMapping
    public void getCommunities() {

    }

    @PostMapping
    public void addCommunity() {

    }

    @GetMapping("/{cId}")
    public void getCommunity(@PathVariable String cId) {

    }

    @DeleteMapping("/{cId}")
    public void deleteCommunity(@PathVariable int cId) {
        communityService.deleteCommunity((long) cId);
    }

}

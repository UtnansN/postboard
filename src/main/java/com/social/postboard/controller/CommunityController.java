package com.social.postboard.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.social.postboard.dto.CommunityPageDTO;
import com.social.postboard.entity.Community;
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
    public void addCommunity(@RequestBody Community community) {
        communityService.addCommunity(community);
    }

    @GetMapping("/{cId}")
    public CommunityPageDTO getCommunity(@PathVariable String cId) {
        CommunityPageDTO communityPage = communityService.findCommunity(cId);

        communityPage.add(linkTo(methodOn(CommunityController.class).getCommunity(cId)).withSelfRel());
        return communityPage;
    }

    @DeleteMapping("/{cId}")
    public void deleteCommunity(@PathVariable String cId) {
        communityService.deleteCommunity(cId);
    }

}

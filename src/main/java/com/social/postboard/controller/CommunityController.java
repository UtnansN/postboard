package com.social.postboard.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.social.postboard.dto.CommunityDTO;
import com.social.postboard.dto.CommunityPageDTO;
import com.social.postboard.entity.Community;
import com.social.postboard.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/communities")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @GetMapping
    public PagedModel<EntityModel<CommunityDTO>> getCommunities(Pageable pageable, PagedResourcesAssembler<CommunityDTO> assembler) {
        Page<CommunityDTO> communities = communityService.getCommunities(pageable);

        PagedModel<EntityModel<CommunityDTO>> model = assembler.toModel(communities);
        model.forEach(m -> m.add(linkTo(methodOn(CommunityController.class)
                .getCommunity(Objects.requireNonNull(m.getContent()).getTag(), null)).withSelfRel()));
        return model;
    }

    @PostMapping
    public void addCommunity(@RequestBody CommunityDTO community) {
        communityService.addCommunity(community);
    }

    @GetMapping("/{tag}")
    public CommunityPageDTO getCommunity(@PathVariable String tag, Pageable pageable) {
        CommunityPageDTO communityPage = communityService.findCommunity(tag);
        // TODO: Pages in JSON
        communityPage.add(linkTo(methodOn(CommunityController.class).getCommunity(tag, pageable)).withSelfRel());
        return communityPage;
    }

    @PutMapping("/{tag}")
    public void updateCommunity(@PathVariable String tag, @RequestBody CommunityDTO communityDTO) {
        communityService.updateCommunity(tag, communityDTO);
    }

    @DeleteMapping("/{tag}")
    public void deleteCommunity(@PathVariable String tag) {
        communityService.deleteCommunity(tag);
    }

}

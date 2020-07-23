package com.social.postboard.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
public class CommunityPageDTO extends RepresentationModel<CommunityPageDTO> {

    private String title;

    private String description;

    private List<ShortPostDTO> posts;
}

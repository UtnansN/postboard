package com.social.postboard.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class CommunityDTO extends RepresentationModel<CommunityDTO> {

    private String tag;

    private String title;

    private String description;

    private Long memberCount;
}

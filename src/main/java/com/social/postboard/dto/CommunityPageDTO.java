package com.social.postboard.dto;

import lombok.Data;

import java.util.List;

@Data
public class CommunityPageDTO {

    private String title;

    private String description;

    private List<ShortPostDTO> posts;
}

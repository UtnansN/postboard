package com.social.postboard.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CommunityPageDTO extends CommunityDTO {

    private LocalDateTime creationDate;

    private List<ShortPostDTO> posts;
}

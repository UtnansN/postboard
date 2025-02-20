package com.social.postboard.dto;

import com.social.postboard.entity.PostType;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Data
public class ShortPostDTO extends RepresentationModel<ShortPostDTO> {

    private String title;

    private PostType type;

    private LocalDateTime creationDate;

    private Long upVotes;
}

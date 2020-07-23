package com.social.postboard.dto;

import com.social.postboard.entity.PostType;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class FullPostDTO extends RepresentationModel<FullPostDTO> {

    private String title;

    private PostType type;

    private String content;

    private Long upVotes;

}

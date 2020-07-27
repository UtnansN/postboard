package com.social.postboard.dto;

import com.social.postboard.entity.Comment;
import com.social.postboard.entity.PostType;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FullPostDTO extends RepresentationModel<FullPostDTO> {

    private String title;

    private LocalDateTime creationDate;

    private PostType type;

    private String content;

    private Long upVotes;

    private List<Comment> comments;

}

package com.social.postboard.dto;

import com.social.postboard.entity.PostType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShortPostDTO {

    private LocalDateTime creationDate;

    private Long upVotes;

    private PostType type;
}

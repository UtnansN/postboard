package com.social.postboard.mapper;

import com.social.postboard.dto.CommentDTO;
import com.social.postboard.entity.Comment;
import org.mapstruct.Mapper;

@Mapper
public interface CommentMapper {

    Comment toComment(CommentDTO commentDTO);

}

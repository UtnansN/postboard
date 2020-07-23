package com.social.postboard.repository;

import com.social.postboard.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, String> {
}

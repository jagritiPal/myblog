package com.myblog.myblog.repository;

import com.myblog.myblog.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.stream.events.Comment;

public interface CommentRepository extends JpaRepository <CommentEntity, Long> {
}

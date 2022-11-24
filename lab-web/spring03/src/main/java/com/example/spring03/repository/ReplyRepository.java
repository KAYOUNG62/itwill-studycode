package com.example.spring03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring03.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{

}

package com.huflit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huflit.entity.GroupMessage;

public interface GroupMessageRepository extends JpaRepository<GroupMessage, Integer>{

	List<GroupMessage> findByGroupId(int groupId);
}

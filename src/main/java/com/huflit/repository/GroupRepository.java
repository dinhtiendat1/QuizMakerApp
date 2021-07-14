package com.huflit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.huflit.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer>{

	List<Group> findByNameContaining(String name);

	@Query("SELECT g FROM Group g "
			+ "INNER JOIN UserGroup ug "
			+ "ON g.id = ug.id.groupId "
			+ "WHERE ug.id.userId = :id ")
	List<Group> findAllOfMyGroup(@Param("id") Integer id);
	
	@Query("SELECT g FROM Group g "
			+ "INNER JOIN UserGroup ug "
			+ "ON g.id = ug.id.groupId "
			+ "WHERE ug.id.userId = :id "
			+ "AND g.name LIKE '%:name%' ")
	List<Group> findByNameOfMyGroup(@Param("id") Integer id, @Param("name") String name);
}

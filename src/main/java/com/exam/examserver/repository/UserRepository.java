package com.exam.examserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.examserver.models.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

	@Query(value="select * from user where username=:usr", nativeQuery= true)
	AppUser findByUsername(@Param("usr")String username);
	
	@Query(value="select u.* from user u inner join roles r on u.role_id=r.id where r.rolename=:role ", nativeQuery= true)
	List<AppUser> findByRole(@Param("role")String role);

}

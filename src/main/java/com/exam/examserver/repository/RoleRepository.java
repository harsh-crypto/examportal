package com.exam.examserver.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.examserver.models.Role;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query(value = "select * from role where role_name=:n",nativeQuery = true)
    Role findByName(@Param("n")String name);
}

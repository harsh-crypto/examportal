package com.exam.examserver.repository;

import com.exam.examserver.models.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepo extends JpaRepository<Credential,Integer> {
    @Query(value = "Select count(*) from Credential where usr=:id",nativeQuery = true)
    int numberOfCredentials(@Param("id")int ID);
}

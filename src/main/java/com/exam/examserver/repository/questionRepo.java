package com.exam.examserver.repository;

import com.exam.examserver.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface questionRepo extends JpaRepository<Question,Integer> {
}

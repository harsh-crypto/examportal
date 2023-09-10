package com.exam.examserver.repository;

import com.exam.examserver.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {
    @Query(value="Select * from question where QuestionIdentifier=:QID")
    Question findByQID(@Param("QID") String QID);

    @Query(value="Select * from question where sub=(select id from Subject where subName=:name)")
    List<Question> findBySubject(@Param("name") String name);

    @Query(value="Select * from question where typeOfQuestion=:toq")
    List<Question> findByTOQ(@Param("toq") String TOQ);
}

package com.torpe.genie.Repositories;

import com.torpe.genie.Models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    @Query("SELECT q FROM Question q WHERE q.creator.id = :creatorId ORDER BY q.id DESC")
    List<Question> findByCreator_id(@Param("creatorId") Long creatorId);
    Long countQuestionByCreator_idAndCorrect(Long creatorId , boolean correct);

}

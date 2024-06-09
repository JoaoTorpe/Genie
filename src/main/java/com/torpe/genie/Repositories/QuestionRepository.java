package com.torpe.genie.Repositories;

import com.torpe.genie.Models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    List<Question> findByCreator_id(Long creator_id);
}

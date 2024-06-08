package com.torpe.genie.Repositories;

import com.torpe.genie.Models.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionsRepository extends JpaRepository<Options,Long> {
}

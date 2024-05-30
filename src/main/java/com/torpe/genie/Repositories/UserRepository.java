package com.torpe.genie.Repositories;

import com.torpe.genie.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository  extends JpaRepository<User,Long> {

}

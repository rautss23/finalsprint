package com.creditcard.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import com.creditcard.entities.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
@Query("Select u from User u where u.userName=?1 and u.password=?2")
public Optional<User> validateUserCredentials(String userName, String password);



public boolean existsByuserName(String userName);

@Query("Select u from User u where u.phNumber=:pnumber and u.userName=:uName")
Optional<User> validateUserMobile(@Param("pnumber") Long mobile, @Param("uName") String userName);


}
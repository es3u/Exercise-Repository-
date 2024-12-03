package com.example.exercise_repository.Repository;

import com.example.exercise_repository.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select i from User i where i.id = ?1")
    User findUById(Integer id);

    User findUserByEmail(String email);

    List findUserByRole(String role);
@Query("select a from User a where a.age>=?1 AND a.age<=?2")
    List<User> findUserByRaang(Integer min , Integer max);

//    @Query("select b from User b where b.password = ?1 AND  b.userName = ?2  ")
//    User findUserByPasswordAndUserName(String password, String userName);

    User findUserByPasswordAndUserName(String password, String userName );


}

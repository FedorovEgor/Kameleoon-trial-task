package com.back.portal.repository;

import com.back.portal.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT COUNT(user_id) FROM users WHERE user_email ILIKE :email", nativeQuery = true)
    int findEmailRepetition(@Param("email") String email);
}

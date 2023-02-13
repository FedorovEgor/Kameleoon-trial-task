package com.back.portal.repository;

import com.back.portal.model.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuoteRepository extends JpaRepository<QuoteEntity, Integer> {

    @Query("select q from QuoteEntity q where q.userId = :userId")
    List<QuoteEntity> getQuotesByUser(@Param("userId") int userId);

    @Query(value = "SELECT * FROM quotes ORDER BY like_counter DESC LIMIT :limit", nativeQuery = true)
    List<QuoteEntity> getTopQuotes(@Param("limit") int limit);

    @Query(value = "SELECT * FROM quotes ORDER BY like_counter LIMIT :limit", nativeQuery = true)
    List<QuoteEntity> getFlopQuotes(@Param("limit") int limit);

    @Query(value = "SELECT * FROM quotes WHERE user_id = :userId ORDER BY like_counter DESC LIMIT :limit", nativeQuery = true)
    List<QuoteEntity> getTopQuotesFromUser(@Param("userId") int userId, @Param("limit") int limit);

    @Query(value = "SELECT * FROM quotes WHERE user_id = :userId ORDER BY like_counter LIMIT :limit", nativeQuery = true)
    List<QuoteEntity> getFlopQuotesFromUser(@Param("userId") int userId, @Param("limit") int limit);
}

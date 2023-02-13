package com.back.portal.repository;

import com.back.portal.model.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VoteRepository extends JpaRepository<VoteEntity, Integer> {

    @Query("select v from VoteEntity v where v.userId = :userId")
    List<VoteEntity> getVotesByUserId(int userId);

    @Query("select v from VoteEntity v where v.quoteId = :quoteId and v.userId = :userId")
    Optional<VoteEntity> getVoteByQuoteIdAndUserId(@Param("quoteId") int quoteId, @Param("userId") int userId);

    @Query("select v from VoteEntity v where v.quoteId = :quoteId group by v.creationDate")
    List<VoteEntity> getVotesGraphForQuote(@Param("quoteId") int quoteId);
}

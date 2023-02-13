package com.back.portal.service;

import com.back.portal.dto.VoteDto;
import com.back.portal.enums.ErrorMessagesEnum;
import com.back.portal.exception.*;
import com.back.portal.mapper.QuoteMapper;
import com.back.portal.mapper.VoteMapper;
import com.back.portal.model.QuoteEntity;
import com.back.portal.model.UserEntity;
import com.back.portal.model.VoteEntity;
import com.back.portal.repository.QuoteRepository;
import com.back.portal.repository.UserRepository;
import com.back.portal.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class VoteService {

    @Autowired
    VoteRepository voteRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    QuoteRepository quoteRepository;

    VoteMapper voteMapper = VoteMapper.INSTANCE;


    @Transactional
    public void createVote(VoteDto voteDto) {
        QuoteEntity quoteEntity = quoteRepository.findById(voteDto.getQuoteId())
                .orElseThrow(() -> new QuoteNotFoundException(ErrorMessagesEnum.NO_QUOTE_FOUND.value));
        UserEntity userEntity = userRepository.findById(voteDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(ErrorMessagesEnum.NO_USER_FOUND.value));

        if (voteDto.getUserId().equals(quoteEntity.getUserId())) {
            throw new SelfVoteException(ErrorMessagesEnum.SELF_VOTE_ERR.value);
        }

        VoteEntity voteExistingEntity = getVoteByQuoteIdAndUserId(voteDto.getQuoteId(), voteDto.getUserId());
        if (voteExistingEntity != null) {
            if (voteExistingEntity.getIsUpvote() == voteDto.getIsUpvote())
                throw new VoteLimitException(ErrorMessagesEnum.EXISTING_VOTE_ERR.value);
            else {
                voteExistingEntity.setIsUpvote(voteDto.getIsUpvote());
                VoteDto voteEditedDto = voteMapper.toVoteDto(voteExistingEntity);
                updateLikesCounter(voteEditedDto, quoteEntity, true);
                voteExistingEntity.setCreationDate(new Date());
                voteRepository.save(voteExistingEntity);
                return;
            }
        }

        updateLikesCounter(voteDto, quoteEntity, false);

        voteDto.setCreationDate(new Date());
        voteRepository.save(voteMapper.toVoteEntity(voteDto));
    }

    @Transactional
    public VoteEntity getVoteByQuoteIdAndUserId(Integer quoteId, Integer userId) {
        return voteRepository.getVoteByQuoteIdAndUserId(quoteId, userId).orElse(null);
    }


    @Transactional
    void updateLikesCounter(VoteDto voteDto, QuoteEntity quoteEntity, boolean isSelfUpdate) {
        if (isSelfUpdate) {
            if (voteDto.getIsUpvote()) {
                quoteEntity.setLikeCounter(quoteEntity.getLikeCounter() + 2);
            } else {
                quoteEntity.setLikeCounter(quoteEntity.getLikeCounter() - 2);
            }
            quoteRepository.save(quoteEntity);
            return;
        }

        if (voteDto.getIsUpvote()) {
            quoteEntity.setLikeCounter(quoteEntity.getLikeCounter() + 1);
        } else {
            quoteEntity.setLikeCounter(quoteEntity.getLikeCounter() - 1);
        }
        quoteRepository.save(quoteEntity);
    }

    @Transactional
    public VoteDto getVoteById(Integer voteId) {
        VoteEntity voteEntity = voteRepository.findById(voteId)
                .orElseThrow(() -> new VoteNotFoundException(ErrorMessagesEnum.NO_VOTE_FOUND.value));

        return voteMapper.toVoteDto(voteEntity);
    }

    @Transactional
    public Set<VoteDto> getVotesFromUser(Integer userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(ErrorMessagesEnum.NO_USER_FOUND.value));

        return voteMapper.toVoteDtoSet(userEntity.getVoteEntititySet());
    }

    @Transactional
    public List<VoteDto> getVotesGraphForQuote(Integer quoteId) {
        QuoteEntity quoteEntity = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new QuoteNotFoundException(ErrorMessagesEnum.NO_QUOTE_FOUND.value));

        return voteMapper.toVoteDtoList(voteRepository.getVotesGraphForQuote(quoteId));
    }

    @Transactional
    public void deleteVote(Integer voteId) {
        VoteEntity voteEntity = voteRepository.findById(voteId).orElseThrow(() -> new VoteNotFoundException(ErrorMessagesEnum.NO_VOTE_FOUND.value));
        voteRepository.delete(voteEntity);
    }
}

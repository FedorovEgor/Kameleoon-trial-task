package com.back.portal.service;

import com.back.portal.dto.QuoteDto;
import com.back.portal.dto.QuoteEditRequestDto;
import com.back.portal.enums.ErrorMessagesEnum;
import com.back.portal.exception.QuoteNotFoundException;
import com.back.portal.exception.UserNotFoundException;
import com.back.portal.mapper.QuoteMapper;
import com.back.portal.mapper.VoteMapper;
import com.back.portal.model.QuoteEntity;
import com.back.portal.model.UserEntity;
import com.back.portal.model.VoteEntity;
import com.back.portal.repository.QuoteRepository;
import com.back.portal.repository.UserRepository;
import com.back.portal.repository.VoteRepository;
import com.back.portal.utils.RandomNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class QuoteService {
    @Autowired
    QuoteRepository quoteRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    VoteService voteService;

    QuoteMapper quoteMapper = QuoteMapper.INSTANCE;
    VoteMapper voteMapper = VoteMapper.INSTANCE;

    @Transactional
    public void createQuote(QuoteDto quoteDto) {
        UserEntity userEntity = userRepository.findById(quoteDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(ErrorMessagesEnum.NO_USER_FOUND.value));
        QuoteEntity quoteEntity = quoteMapper.toQuoteEntity(quoteDto);
        quoteRepository.save(quoteEntity);
    }

    @Transactional
    public Set<QuoteDto> getAllQuotesFromUser(Integer userId) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            UserEntity userEntity = userOptional.get();
            return quoteMapper.toQuoteDtoSet(userEntity.getQuoteEntitySet());
        }
        return Collections.emptySet();
    }

    @Transactional
    public QuoteDto getRandomQuote() {
        List<QuoteEntity> allQuotes = quoteRepository.findAll();
        if (allQuotes.isEmpty()) {
            throw new QuoteNotFoundException(ErrorMessagesEnum.EMPTY_QUOTES.value);
        }
        QuoteEntity randomQuote = allQuotes.get(RandomNumberUtil.getRandomFromLimit(allQuotes.size()));
        return quoteMapper.toQuoteDto(randomQuote);
    }

    @Transactional
    public QuoteDto getRandomQuoteFromUser(Integer userId) {
        List<QuoteEntity> quoteEntities = quoteRepository.getQuotesByUser(userId);
        if (quoteEntities.isEmpty()) {
            throw new QuoteNotFoundException(ErrorMessagesEnum.EMPTY_QUOTES.value);
        }
        QuoteEntity randomQuote = quoteEntities.get(RandomNumberUtil.getRandomFromLimit(quoteEntities.size()));
        return quoteMapper.toQuoteDto(randomQuote);
    }

    @Transactional
    public List<QuoteDto> getTopQuotes(Integer limit) {
        return quoteMapper.toQuoteDtoList(quoteRepository.getTopQuotes(limit));
    }

    @Transactional
    public List<QuoteDto> getFlopQuotes(Integer limit) {
        return quoteMapper.toQuoteDtoList(quoteRepository.getFlopQuotes(limit));
    }

    @Transactional
    public List<QuoteDto> getTopQuotesFromUser(Integer userId, Integer limit) {
        return quoteMapper.toQuoteDtoList(quoteRepository.getTopQuotesFromUser(userId, limit));
    }

    @Transactional
    public List<QuoteDto> getFlopQuotesFromUser(Integer userId, Integer limit) {
        return quoteMapper.toQuoteDtoList(quoteRepository.getFlopQuotesFromUser(userId, limit));
    }

    @Transactional
    public QuoteDto getQuoteById(Integer quoteId) {
        QuoteEntity quoteEntity = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new QuoteNotFoundException(ErrorMessagesEnum.NO_QUOTE_FOUND.value));
        return quoteMapper.toQuoteDto(quoteEntity);
    }

    @Transactional
    public void deleteQuote(Integer quoteId) {
        QuoteEntity quoteEntity = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new QuoteNotFoundException(ErrorMessagesEnum.NO_QUOTE_FOUND.value));
        for (VoteEntity eachVote : quoteEntity.getVoteEntities()) {
            voteService.deleteVote(eachVote.getVoteId());
        }
        quoteRepository.delete(quoteEntity);
    }

    @Transactional
    public void editQuote(QuoteEditRequestDto quoteEditDto, Integer quoteId) {
        QuoteEntity quoteEntity = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new QuoteNotFoundException(ErrorMessagesEnum.NO_QUOTE_FOUND.value));

        quoteEntity.setText(quoteEditDto.getText());
        quoteEntity.setDateOfCreation(new Date());

        quoteRepository.save(quoteEntity);
    }
}

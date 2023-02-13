package com.back.portal.contoller;

import com.back.portal.dto.VoteDto;
import com.back.portal.service.VoteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("api/v1/votes")
@Slf4j
public class VoteController {

    @Autowired
    VoteService voteService;

    @PostMapping(value = "save/vote", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Save vote from user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public void createVote(@RequestBody VoteDto voteDto) {
        log.debug("Request for createVote: {}", voteDto);
        voteService.createVote(voteDto);
    }

    @GetMapping(value = "get/{voteId}")
    @ResponseBody
    @ApiOperation(value = "Get vote by Id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public VoteDto getVoteById(@PathVariable("voteId") Integer voteId) {
        log.debug("Request for getVoteById: {}", voteId);
        return voteService.getVoteById(voteId);
    }

    @GetMapping(value = "get/user/{userId}")
    @ResponseBody
    @ApiOperation(value = "Get votes from user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public Set<VoteDto> getVotesFromUser(@PathVariable("userId") Integer userId) {
        log.debug("Request for getVotesFromUser: {}", userId);
        return voteService.getVotesFromUser(userId);
    }

    @GetMapping(value = "get/graph/{quoteId}")
    @ResponseBody
    @ApiOperation(value = "Get votes graph for quote", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public List<VoteDto> getVotesGraphForQuote(@PathVariable("quoteId") Integer quoteId) {
        log.debug("Request for getVotesGraphForQuote: {}", quoteId);
        return voteService.getVotesGraphForQuote(quoteId);
    }
}

package com.back.portal.contoller;

import com.back.portal.dto.QuoteDto;
import com.back.portal.dto.QuoteEditRequestDto;
import com.back.portal.service.QuoteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping("api/v1/quotes")
@Slf4j
public class QuoteController {

    @Autowired
    QuoteService quoteService;

    @PostMapping(value = "save/quote", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Save quote from user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public void createQuote(@RequestBody QuoteDto quoteDto) {
        log.debug("Request for createQuote: {}", quoteDto);
        quoteService.createQuote(quoteDto);
    }

    @GetMapping(value = "get/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Get quote by it's identification number", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public QuoteDto getQuoteById(@PathVariable("quoteId") Integer quoteId) {
        log.debug("Request for getQuoteById: {}", quoteId);
        return quoteService.getQuoteById(quoteId);
    }

    @GetMapping(value = "get/{userId}")
    @ResponseBody
    @ApiOperation(value = "Get quotes from user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public Set<QuoteDto> getQuotesFromUser(
            @ApiParam(required = true, value = "User identification number", example = "1")
            @PathVariable Integer userId)
    {
        log.debug("Request for getQuotesFromUser: {}", userId);
        return quoteService.getAllQuotesFromUser(userId);
    }

    @GetMapping(value = "get/random")
    @ResponseBody
    @ApiOperation(value = "Get random quote", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public QuoteDto getRandomQuote() {
        log.debug("Request for getRandomQuotes");
        return quoteService.getRandomQuote();
    }

    @GetMapping(value = "get/random/{userId}")
    @ResponseBody
    @ApiOperation(value = "Get random quote from user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public QuoteDto getRandomQuoteByUser(
            @ApiParam(required = true, value = "User identification number", example = "1")
            @PathVariable Integer userId) {
        log.debug("Request for getRandomQuoteByUser: {}", userId);
        return quoteService.getRandomQuoteFromUser(userId);
    }

    @GetMapping(value = "get/top/{limit}")
    @ResponseBody
    @ApiOperation(value = "Get number of top quotes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public List<QuoteDto> getTopQuotes(
            @ApiParam(required = true, value = "Limit for top quotes", example = "1")
            @PathVariable("limit") Integer limit) {
        log.debug("Request for getTopQuotes: {}", limit);
        return quoteService.getTopQuotes(limit);
    }

    @GetMapping(value = "get/top/{userId}/{limit}")
    @ResponseBody
    @ApiOperation(value = "Get number of top quotes from user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public List<QuoteDto> getTopQuotesFromUser(
            @ApiParam(required = true, value = "User identification number", example = "1")
            @PathVariable("userId") Integer userId,
            @ApiParam(required = true, value = "Limit for top quotes", example = "1")
            @PathVariable("limit") Integer limit) {
        log.debug("Request for getTopQuotesFromUser: {}, {}", userId, limit);
        return quoteService.getTopQuotesFromUser(userId, limit);
    }

    @GetMapping(value = "get/flop/{limit}")
    @ResponseBody
    @ApiOperation(value = "Get number of flop quotes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public List<QuoteDto> getFlopQuotes(
            @ApiParam(required = true, value = "Limit for flop quotes", example = "1")
            @PathVariable("limit") Integer limit) {
        log.debug("Request for getFlopQuotes: {}", limit);
        return quoteService.getFlopQuotes(limit);
    }

    @GetMapping(value = "get/flop/{userId}/{limit}")
    @ResponseBody
    @ApiOperation(value = "Get number of flop quotes from user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public List<QuoteDto> getFlopQuotesFromUser(
            @ApiParam(required = true, value = "User identification number", example = "1")
            @PathVariable("userId") Integer userId,
            @ApiParam(required = true, value = "Limit for flop quotes", example = "1")
            @PathVariable("limit") Integer limit) {
        log.debug("Request for getFlopQuotesFromUser: {}, {}", userId, limit);
        return quoteService.getFlopQuotesFromUser(userId, limit);
    }

    @DeleteMapping(value = "delete/{quoteId}")
    @ResponseBody
    @ApiOperation(value = "Delete quote", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public void deleteQuote(Integer quoteId) {
        log.debug("Request for deleteQuote: {}", quoteId);
        quoteService.deleteQuote(quoteId);
    }

    @PutMapping(value = "edit/{quoteId}")
    @ResponseBody
    @ApiOperation(value = "Edit quote", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public void editQuote(@RequestBody QuoteEditRequestDto quoteEditDto, @PathVariable Integer quoteId) {
        log.debug("Request for editQuote: {}, {}", quoteEditDto, quoteId);
        quoteService.editQuote(quoteEditDto, quoteId);
    }
}

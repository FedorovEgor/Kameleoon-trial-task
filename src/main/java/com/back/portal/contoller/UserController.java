package com.back.portal.contoller;

import com.back.portal.dto.UserDto;
import com.back.portal.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("api/v1/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "get/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Get user info", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public UserDto getUserInfo(
            @ApiParam(required = true, value = "User identification number", example = "1")
            @PathVariable Integer userId) {
        log.debug("Request for getUserInfo: userId - {}", userId);
        return userService.getUserInfoById(userId);
    }
}

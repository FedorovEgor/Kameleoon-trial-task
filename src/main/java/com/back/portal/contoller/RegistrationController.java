package com.back.portal.contoller;

import com.back.portal.dto.UserRegistrationRequestDto;
import com.back.portal.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("api/v1/registration")
@Slf4j
public class RegistrationController {

    @Autowired
    UserService userService;

    @PostMapping(value = "save/user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Register new user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operation's done")
    })
    public void createUser(@RequestBody UserRegistrationRequestDto userDto) {
        log.debug("Request for createUser: {}", userDto);
        userService.saveUser(userDto);
    }

}

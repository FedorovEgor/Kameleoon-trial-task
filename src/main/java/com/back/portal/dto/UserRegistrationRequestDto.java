package com.back.portal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@ApiModel(description = "Информация о пользователе")
public class UserRegistrationRequestDto {

    @ApiModelProperty(value = "User identification number", required = true, readOnly = true)
    private Integer userId;
    @ApiModelProperty(value = "User name", required = true, example = "Ivan")
    private String firstName;
    @ApiModelProperty(value = "User surname", required = true, example = "Ivanov")
    private String lastName;
    @ApiModelProperty(value = "User email", required = true, example = "IvanIvanov@gmail.com")
    private String email;
    @ApiModelProperty(value = "user password", required = true, example = "password")
    private String password;
    @ApiModelProperty(value = "Date of registration")
    private Date registrationDate;
}

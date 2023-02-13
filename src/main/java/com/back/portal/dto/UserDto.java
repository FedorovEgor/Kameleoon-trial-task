package com.back.portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserDto {
    @ApiModelProperty(value = "User identification number", required = true, readOnly = true)
    private Integer userId;
    @ApiModelProperty(value = "User name", required = true)
    private String firstName;
    @ApiModelProperty(value = "User surname", required = true)
    private String lastName;
    @ApiModelProperty(value = "User email", required = true)
    private String email;
    @ApiModelProperty(value = "user password", required = true, readOnly = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ApiModelProperty(value = "Date of registration")
    private Date registrationDate;
}

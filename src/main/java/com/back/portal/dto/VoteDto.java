package com.back.portal.dto;

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
public class VoteDto {

    @ApiModelProperty(value = "Vote identification number", required = true, readOnly = true)
    private Integer voteId;

    @ApiModelProperty(value = "Quote identification number", required = true)
    private Integer quoteId;

    @ApiModelProperty(value = "User identification number", required = true)
    private Integer userId;

    @ApiModelProperty(value = "User identification number", required = true)
    private Boolean isUpvote;

    @ApiModelProperty(value = "Date of vote", readOnly = true)
    private Date creationDate;
}

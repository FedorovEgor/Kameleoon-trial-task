package com.back.portal.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class QuoteDto {
    @ApiModelProperty(value = "Quote identification number", required = true, readOnly = true)
    private Integer quoteId;

    @ApiModelProperty(value = "User identification number", required = true)
    private Integer userId;

    @ApiModelProperty(value = "Quote text", required = true)
    private String text;

    @ApiModelProperty(value = "Date of creation", required = true)
    private Date dateOfCreation;

    @ApiModelProperty(value = "User name", required = true, readOnly = true)
    private int likeCounter;

    @ApiModelProperty(value = "Votes", required = false, readOnly = true)
    @Builder.Default
    private Set<VoteDto> voteEntities = new HashSet<>();
}

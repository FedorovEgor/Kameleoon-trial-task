package com.back.portal.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class QuoteEditRequestDto {
    @ApiModelProperty(value = "Quote text", required = true)
    private String text;
}

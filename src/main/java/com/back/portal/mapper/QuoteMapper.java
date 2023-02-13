package com.back.portal.mapper;

import com.back.portal.dto.QuoteDto;
import com.back.portal.model.QuoteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface QuoteMapper {

    QuoteMapper INSTANCE = Mappers.getMapper(QuoteMapper.class);

    QuoteDto toQuoteDto(QuoteEntity quoteEntity);
    QuoteEntity toQuoteEntity(QuoteDto quoteDto);

    Set<QuoteDto> toQuoteDtoSet(Set<QuoteEntity> quoteEntities);
    List<QuoteDto> toQuoteDtoList(List<QuoteEntity> quoteEntities);
}

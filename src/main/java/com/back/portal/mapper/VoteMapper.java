package com.back.portal.mapper;

import com.back.portal.dto.VoteDto;
import com.back.portal.model.VoteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface VoteMapper {

    VoteMapper INSTANCE = Mappers.getMapper(VoteMapper.class);

    VoteDto toVoteDto(VoteEntity voteEntity);
    VoteEntity toVoteEntity(VoteDto voteDto);
    Set<VoteDto> toVoteDtoSet(Set<VoteEntity> voteEntitySet);
    Set<VoteEntity> toVoteEntities(Set<VoteDto> voteDtoSet);
    List<VoteDto> toVoteDtoList(List<VoteEntity> voteEntityList);

}

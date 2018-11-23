package reposts.core.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import reposts.core.dto.DictionaryDTO;
import reposts.core.entities.Dictionary;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DictionaryMapper {

    DictionaryMapper INSTANCE = Mappers.getMapper(DictionaryMapper.class);

    Dictionary fromDTO(DictionaryDTO dictionaryDTO);

    DictionaryDTO toDTO(Dictionary dictionary);

    List<Dictionary> fromDTO(List<DictionaryDTO> dictionariesDTO);

    List<DictionaryDTO> toDTO(List<Dictionary> dictionaries);
}

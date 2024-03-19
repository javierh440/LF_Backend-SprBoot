package com.munihuamanga.lf_backend.models.mapper;

import com.munihuamanga.lf_backend.models.dto.RubroNegocioDTO;
import com.munihuamanga.lf_backend.models.entities.RubroNegocio;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface RubroNegocioMapper {
    RubroNegocioDTO toDTO(RubroNegocio rubroNegocio);
    RubroNegocio toEntity(RubroNegocioDTO rubroNegocioDTO);
}

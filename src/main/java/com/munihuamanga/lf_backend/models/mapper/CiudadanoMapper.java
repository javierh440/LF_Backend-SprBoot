package com.munihuamanga.lf_backend.models.mapper;

import com.munihuamanga.lf_backend.models.dto.CiudadanoDTO;
import com.munihuamanga.lf_backend.models.entities.Ciudadano;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface CiudadanoMapper {

    @Mapping(source = "tipo", target = "tipo")
    CiudadanoDTO toDTO(Ciudadano ciudadano);

    @Mapping(source = "tipo", target = "tipo")
    Ciudadano toEntity(CiudadanoDTO ciudadanoDTO);
}

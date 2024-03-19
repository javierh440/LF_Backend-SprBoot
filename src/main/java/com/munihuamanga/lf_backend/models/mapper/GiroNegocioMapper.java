package com.munihuamanga.lf_backend.models.mapper;

import com.munihuamanga.lf_backend.models.dto.GiroNegocioDTO;
import com.munihuamanga.lf_backend.models.entities.GiroNegocio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface GiroNegocioMapper {
    @Mapping(source = "rubroNegocio.id", target = "rubroNegocioId")
    @Mapping(source = "rubroNegocio.nombre", target = "rubroNegocioNombre")
    GiroNegocioDTO toDTO(GiroNegocio giroNegocio);

    @Mapping(source = "rubroNegocioId", target = "rubroNegocio.id")
    GiroNegocio toEntity(GiroNegocioDTO giroNegocioDTO);

}

package com.munihuamanga.lf_backend.models.mapper;

import com.munihuamanga.lf_backend.models.dto.InspeccionDTO;
import com.munihuamanga.lf_backend.models.entities.Inspeccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface InspeccionMapper {

    @Mapping(source = "solicitud.id", target = "solicitudId")
    InspeccionDTO toDTO(Inspeccion inspeccion);

    @Mapping(source = "solicitudId", target = "solicitud.id")
    Inspeccion toEntity(InspeccionDTO inspeccionDTO);
}

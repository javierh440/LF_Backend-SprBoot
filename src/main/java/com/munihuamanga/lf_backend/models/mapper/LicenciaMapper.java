package com.munihuamanga.lf_backend.models.mapper;

import com.munihuamanga.lf_backend.models.dto.LicenciaDTO;
import com.munihuamanga.lf_backend.models.entities.Licencia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface LicenciaMapper {
    @Mapping(source = "solicitud.id", target = "solicitudId")
    @Mapping(source = "estado", target = "estado")
    LicenciaDTO toDTO(Licencia licencia);

    @Mapping(source = "solicitudId", target = "solicitud.id")
    @Mapping(source = "estado", target = "estado")
    Licencia toEntity(LicenciaDTO licenciaDTO);
}

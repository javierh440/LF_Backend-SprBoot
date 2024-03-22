package com.munihuamanga.lf_backend.models.mapper;

import com.munihuamanga.lf_backend.models.dto.SolicitudDTO;
import com.munihuamanga.lf_backend.models.entities.Solicitud;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface SolicitudMapper {
    @Mapping(source = "ciudadano.id", target = "ciudadanoId")
    @Mapping(source = "giroNegocio.id", target = "giroNegocioId")
    @Mapping(source = "estado", target = "estado")
    SolicitudDTO toDTO(Solicitud solicitud);

    @Mapping(source = "ciudadanoId", target = "ciudadano.id")
    @Mapping(source = "giroNegocioId", target = "giroNegocio.id")
    @Mapping(source = "estado", target = "estado")
    Solicitud toEntity(SolicitudDTO solicitudDTO);

}

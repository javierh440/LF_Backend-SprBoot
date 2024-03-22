package com.munihuamanga.lf_backend.models.mapper;

import com.munihuamanga.lf_backend.models.dto.CertificadoDTO;
import com.munihuamanga.lf_backend.models.entities.Certificado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface CertificadoMapper {

    @Mapping(target = "licenciaId", source = "licencia.id")
    CertificadoDTO toDTO(Certificado certificado);

    @Mapping(target = "licencia.id", source = "licenciaId")
    Certificado toEntity(CertificadoDTO certificadoDTO);
}

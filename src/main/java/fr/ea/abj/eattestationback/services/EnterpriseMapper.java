package fr.ea.abj.eattestationback.services;

import fr.ea.abj.eattestationback.repository.domain.Enterprise;
import fr.ea.abj.eattestationback.services.dto.EnterpriseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnterpriseMapper {


    EnterpriseMapper INSTANCE = Mappers.getMapper(EnterpriseMapper.class);

       Enterprise toEnterpriseDomain(EnterpriseDTO enterprise);

    EnterpriseDTO toEnterpriseDTO(Enterprise enterprise);

}

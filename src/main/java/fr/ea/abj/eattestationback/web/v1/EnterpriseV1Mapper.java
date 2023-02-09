package fr.ea.abj.eattestationback.web.v1;

import fr.ea.abj.eattestationback.services.dto.EnterpriseDTO;
import fr.ea.abj.eattestationback.web.v1.dto.EnterpriseV1;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnterpriseV1Mapper {


    EnterpriseV1Mapper INSTANCE = Mappers.getMapper(EnterpriseV1Mapper.class);

       EnterpriseDTO toEnterpriseDTO(EnterpriseV1 enterpriseV1);

    EnterpriseV1 toEnterpriseV1(EnterpriseDTO enterpriseDTO);

}

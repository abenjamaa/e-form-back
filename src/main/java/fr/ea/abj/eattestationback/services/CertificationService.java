package fr.ea.abj.eattestationback.services;

import fr.ea.abj.eattestationback.services.dto.EnterpriseDTO;
import fr.ea.abj.eattestationback.repository.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CertificationService {

   private final CertificationRepository certificationRepository;

    public EnterpriseDTO createEnterprise(EnterpriseDTO enterprise){
        return EnterpriseMapper.INSTANCE.toEnterpriseDTO(certificationRepository.save(EnterpriseMapper.INSTANCE.toEnterpriseDomain(enterprise)));
    }
}

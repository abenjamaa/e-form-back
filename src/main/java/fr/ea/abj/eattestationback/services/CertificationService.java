package fr.ea.abj.eattestationback.services;

import fr.ea.abj.eattestationback.services.dto.EnterpriseDTO;
import fr.ea.abj.eattestationback.repository.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CertificationService {

   private final CertificationRepository certificationRepository;

    public String createEnterprise(EnterpriseDTO enterprise){
        if(certificationRepository.existsBySiret(enterprise.getSiret())){
            return "Siret already exist in database";
        }
         certificationRepository.save(EnterpriseMapper.INSTANCE.toEnterpriseDomain(enterprise));
        return "enterprise : " + enterprise.getEnterprise() + " with SIRET : " + enterprise.getSiret() + " saved !";
    }

    public List<EnterpriseDTO> getEnterpriseCreatedLastMinute(LocalDateTime now){
        return certificationRepository.findByCreationDateBetween(now.minusMinutes(1), now).stream().map(EnterpriseMapper.INSTANCE::toEnterpriseDTO).collect(Collectors.toList());
    }
}

package fr.ea.abj.eattestationback.web.v1;

import fr.ea.abj.eattestationback.services.CertificationService;
import fr.ea.abj.eattestationback.web.v1.dto.EnterpriseV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/certifications")
@RequiredArgsConstructor
public class CertificationsResource {

    private final CertificationService certificationService;

    @PostMapping("/add-enterprise")
    public ResponseEntity<EnterpriseV1> addEnterprise(@RequestBody EnterpriseV1 enterpriseV1){
        return new ResponseEntity<>(EnterpriseV1Mapper.INSTANCE.toEnterpriseV1(certificationService.createEnterprise(EnterpriseV1Mapper.INSTANCE.toEnterpriseDTO(enterpriseV1))), HttpStatus.OK);
    }


}

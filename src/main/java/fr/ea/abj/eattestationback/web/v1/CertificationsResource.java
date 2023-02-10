package fr.ea.abj.eattestationback.web.v1;

import fr.ea.abj.eattestationback.services.CertificationService;
import fr.ea.abj.eattestationback.web.v1.dto.EnterpriseV1;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/certifications")
@RequiredArgsConstructor
public class CertificationsResource {

    private final CertificationService certificationService;

    @PostMapping("/add-enterprise")
    public ResponseEntity<String> addEnterprise(@Valid @RequestBody EnterpriseV1 enterpriseV1){
        return new ResponseEntity<>(certificationService.createEnterprise(EnterpriseV1Mapper.INSTANCE.toEnterpriseDTO(enterpriseV1)), HttpStatus.OK);
    }

    @Scheduled(cron = "0 * * * * *")
    public void runEveryMinute(){
        certificationService.getEnterpriseCreatedLastMinute(LocalDateTime.now()).forEach(enterpriseDTO -> {
            if(enterpriseDTO.getIso9001()){
                System.out.println(enterpriseDTO.getEnterprise() +"(" + enterpriseDTO.getSiret() +") : Déclenchement de la demande de document Iso9001");
            }
            if(enterpriseDTO.getIso27001()){
                System.out.println(enterpriseDTO.getEnterprise() +" ( " + enterpriseDTO.getSiret() +" ) : Déclenchement de la demande de document Iso27001");
            }

            if(enterpriseDTO.getIso45001()){
                System.out.println(enterpriseDTO.getEnterprise() +" ( " + enterpriseDTO.getSiret() +" ) : Déclenchement de la demande de document Iso45001");
            }
        });

    }


}

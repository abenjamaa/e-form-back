package fr.ea.abj.eattestationback.services.dto;


import lombok.Data;

@Data
public class EnterpriseDTO {

    private String siret;

    private String enterprise;

    private Boolean iso27001;

    private Boolean iso9001;

    private Boolean iso45001;
}

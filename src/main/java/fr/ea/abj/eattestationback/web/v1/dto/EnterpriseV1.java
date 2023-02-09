package fr.ea.abj.eattestationback.web.v1.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EnterpriseV1 {
    @NotNull
    private String siret;
    @NotNull
    private String enterprise;
    @NotNull
    private Boolean iso27001;
    @NotNull
    private Boolean iso9001;
    @NotNull
    private Boolean iso45001;
}

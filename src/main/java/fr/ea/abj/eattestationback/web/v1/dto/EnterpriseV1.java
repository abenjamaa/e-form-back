package fr.ea.abj.eattestationback.web.v1.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
public class EnterpriseV1 {
    @NotEmpty(message = "siret cannot be null or Empty")
    @Length(min = 14, max =14, message = "siret length must be 14")
    @Pattern(regexp="[\\d]{14}", message = "siret length must contain only numbers")
    private String siret;
    @NotEmpty(message = "enterprise cannot be null or Empty")
    private String enterprise;
    @NotNull(message = "iso27001 cannot be null")
    private Boolean iso27001;
    @NotNull(message = "iso9001 cannot be null")
    private Boolean iso9001;
    @NotNull(message = "iso45001 cannot be null")
    private Boolean iso45001;
}

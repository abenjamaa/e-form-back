package fr.ea.abj.eattestationback.repository.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table( name = "e_attestation")
public class Enterprise {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "siret")
    private String siret;
    @Column(name = "enterprise")
    private String enterprise;
    @Column(name = "iso_27001")
    private Boolean iso27001;
    @Column(name = "iso_9001")
    private Boolean iso9001;
    @Column(name = "iso_45001")
    private Boolean iso45001;
    @Column(name = "creation_date")
    @CreationTimestamp
    private LocalDateTime creationDate;

}

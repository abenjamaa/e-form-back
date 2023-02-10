package fr.ea.abj.eattestationback.repository;

import fr.ea.abj.eattestationback.repository.domain.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CertificationRepository extends JpaRepository<Enterprise, Long> {

    boolean existsBySiret(String siret);
    List<Enterprise> findByCreationDateBetween(LocalDateTime begin, LocalDateTime end);
}

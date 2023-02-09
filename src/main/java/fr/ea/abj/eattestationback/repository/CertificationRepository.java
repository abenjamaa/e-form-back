package fr.ea.abj.eattestationback.repository;

import fr.ea.abj.eattestationback.repository.domain.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Enterprise, Long> {
}

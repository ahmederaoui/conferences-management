package ma.enset.conferencesmanagement.repositories;

import ma.enset.conferencesmanagement.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
}

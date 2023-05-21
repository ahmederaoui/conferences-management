package ma.enset.conferencesmanagement.repositories;

import ma.enset.conferencesmanagement.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository<Salle,Long> {
}

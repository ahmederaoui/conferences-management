package ma.enset.conferencesmanagement.repositories;

import ma.enset.conferencesmanagement.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference,Long> {
}

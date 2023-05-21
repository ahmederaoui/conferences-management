package ma.enset.conferencesmanagement.repositories;

import ma.enset.conferencesmanagement.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {
}

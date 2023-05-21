package ma.enset.conferencesmanagement.repositories;

import ma.enset.conferencesmanagement.entities.Invite;
import ma.enset.conferencesmanagement.entities.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker,Long> {
}

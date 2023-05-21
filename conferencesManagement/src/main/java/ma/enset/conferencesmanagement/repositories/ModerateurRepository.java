package ma.enset.conferencesmanagement.repositories;

import ma.enset.conferencesmanagement.entities.Invite;
import ma.enset.conferencesmanagement.entities.Moderateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModerateurRepository extends JpaRepository<Moderateur,Long> {
}

package ma.enset.conferencesmanagement.repositories;

import ma.enset.conferencesmanagement.entities.Invite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InviteRepository extends JpaRepository<Invite,Long> {
}

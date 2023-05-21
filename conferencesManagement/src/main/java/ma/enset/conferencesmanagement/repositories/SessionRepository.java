package ma.enset.conferencesmanagement.repositories;

import ma.enset.conferencesmanagement.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {
}

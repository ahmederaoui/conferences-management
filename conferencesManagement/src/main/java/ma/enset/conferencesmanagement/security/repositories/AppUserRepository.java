package ma.enset.conferencesmanagement.security.repositories;


import ma.enset.conferencesmanagement.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<Participant, Long> {
    Participant findByUserName(String userName);
}

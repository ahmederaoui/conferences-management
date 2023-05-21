package ma.enset.conferencesmanagement.repositories;

import ma.enset.conferencesmanagement.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {
}

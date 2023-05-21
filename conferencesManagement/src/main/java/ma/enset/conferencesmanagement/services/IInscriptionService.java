package ma.enset.conferencesmanagement.services;

import ma.enset.conferencesmanagement.dtos.CommentaireDto;
import ma.enset.conferencesmanagement.dtos.InscriptionDto;
import ma.enset.conferencesmanagement.entities.Commentaire;
import ma.enset.conferencesmanagement.entities.Inscription;

import java.util.List;
import java.util.Optional;

public interface IInscriptionService {
    Inscription addInscription(InscriptionDto inscriptionDto);
    List<Inscription> getAllInscriptions();
    Optional<Inscription> getInscription(Long id);
    void deleteInscription(Long id);
    Commentaire addCommentaire(CommentaireDto commentaireDto, Long idParticipant, Long idConference);
    void deleteCommentaire(Long id);
}

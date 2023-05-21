package ma.enset.conferencesmanagement.services.impl;

import ma.enset.conferencesmanagement.dtos.CommentaireDto;
import ma.enset.conferencesmanagement.dtos.InscriptionDto;
import ma.enset.conferencesmanagement.entities.Commentaire;
import ma.enset.conferencesmanagement.entities.Conference;
import ma.enset.conferencesmanagement.entities.Inscription;
import ma.enset.conferencesmanagement.entities.Participant;
import ma.enset.conferencesmanagement.mappers.ConferenceMappers;
import ma.enset.conferencesmanagement.repositories.*;
import ma.enset.conferencesmanagement.services.IInscriptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class InscriptionServiceImpl implements IInscriptionService {
    private InscriptionRepository inscriptionRepository;
    private ConferenceMappers conferenceMapper;
    private SessionRepository sessionRepository;
    private ParticipantRepository participantRepository;
    private ConferenceRepository conferenceRepository;
    private CommentaireRepository commentaireRepository;

    public InscriptionServiceImpl(InscriptionRepository inscriptionRepository,
                                  ConferenceMappers conferenceMapper, SessionRepository sessionRepository,
                                  ParticipantRepository participantRepository, ConferenceRepository conferenceRepository) {
        this.inscriptionRepository = inscriptionRepository;
        this.conferenceMapper = conferenceMapper;
        this.sessionRepository = sessionRepository;
        this.participantRepository = participantRepository;
        this.conferenceRepository = conferenceRepository;
    }

    @Override
    public Inscription addInscription(InscriptionDto inscriptionDto) {
        return inscriptionRepository.save(conferenceMapper.fromInscriptionDto(inscriptionDto));
    }

    @Override
    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Optional<Inscription> getInscription(Long id) {
        return inscriptionRepository.findById(id);
    }

    @Override
    public void deleteInscription(Long id) {
        inscriptionRepository.deleteById(id);
    }

    @Override
    public Commentaire addCommentaire(CommentaireDto commentaireDto, Long idParticipant, Long idConference) {
        Participant participant = participantRepository.findById(idParticipant).orElseThrow();
        Conference conference = conferenceRepository.findById(idConference).orElseThrow();
        Commentaire commentaire = conferenceMapper.fromCommentaireDto(commentaireDto);
        commentaire.setParticipant(participant);
        conference.getCommentaires().add(commentaire);
        return commentaire;
    }

    @Override
    public void deleteCommentaire(Long id) {
        commentaireRepository.deleteById(id);
    }
}

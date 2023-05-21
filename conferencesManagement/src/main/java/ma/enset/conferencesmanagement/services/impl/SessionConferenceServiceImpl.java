package ma.enset.conferencesmanagement.services.impl;

import ma.enset.conferencesmanagement.dtos.ConferenceDto;
import ma.enset.conferencesmanagement.dtos.SessionDto;
import ma.enset.conferencesmanagement.entities.*;
import ma.enset.conferencesmanagement.mappers.ConferenceMappers;
import ma.enset.conferencesmanagement.repositories.*;
import ma.enset.conferencesmanagement.services.ISessionConferenceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class SessionConferenceServiceImpl implements ISessionConferenceService {
    private ConferenceRepository conferenceRepository;
    private SessionRepository sessionRepository;
    private ModerateurRepository moderateurRepository;
    private SpeakerRepository speakerRepository;
    private ConferenceMappers conferenceMapper;
    private SalleRepository salleRepository;

    public SessionConferenceServiceImpl(ConferenceRepository conferenceRepository,
                                        SessionRepository sessionRepository,
                                        ModerateurRepository moderateurRepository,
                                        SpeakerRepository speakerRepository, ConferenceMappers conferenceMapper, SalleRepository salleRepository) {
        this.conferenceRepository = conferenceRepository;
        this.sessionRepository = sessionRepository;
        this.moderateurRepository = moderateurRepository;
        this.speakerRepository = speakerRepository;
        this.conferenceMapper = conferenceMapper;
        this.salleRepository = salleRepository;
    }
    @Override
    public Conference addConference(ConferenceDto conferenceDto) {
        return conferenceRepository.save(conferenceMapper.fromConferenceDto(conferenceDto));
    }

    @Override
    public Session addSession(SessionDto sessionDto) {
        return sessionRepository.save(conferenceMapper.fromSessionDto(sessionDto));
    }

    @Override
    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    @Override
    public List<Session> getAllSession() {
        return sessionRepository.findAll();
    }

    @Override
    public Optional<Conference> getConference(Long id) {
        return conferenceRepository.findById(id);
    }

    @Override
    public Optional<Session> getSession(Long id) {
        return sessionRepository.findById(id);
    }

    @Override
    public void deleteConference(Long id) {
        conferenceRepository.deleteById(id);
    }

    @Override
    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }

    @Override
    public Session addConferenceToSession(Long idSession, Long idConference) {
        Conference conference = conferenceRepository.findById(idConference).orElseThrow();
        Session session = sessionRepository.findById(idSession).orElseThrow();
        session.getConferences().add(conference);
        conference.setSession(session);
        return session;
    }

    @Override
    public Session addModerateurToSession(Long idSession, Long idModerateur) {
        Moderateur moderateur = moderateurRepository.findById(idModerateur).orElseThrow();
        Session session = sessionRepository.findById(idSession).orElseThrow();
        session.setModerateur(moderateur);
        moderateur.getSessions().add(session);
        return session;
    }

    @Override
    public Session addSalleToSession(Long idSession, Long idSalle) {
        Salle salle = salleRepository.findById(idSalle).orElseThrow();
        Session session = sessionRepository.findById(idSession).orElseThrow();
        session.setSalle(salle);
        return session;
    }

    @Override
    public Conference addSpeakerToConference(Long idConference, Long idSpeaker) {
        Speaker speaker = speakerRepository.findById(idSpeaker).orElseThrow();
        Conference conference = conferenceRepository.findById(idConference).orElseThrow();
        conference.setSpeaker(speaker);
        speaker.getConferences().add(conference);
        return conference;
    }

    /*@Override
    public ConferenceDto addCommentaireToConference(Long idConference, Long idCommentaire) {
        return null;
    }*/
}

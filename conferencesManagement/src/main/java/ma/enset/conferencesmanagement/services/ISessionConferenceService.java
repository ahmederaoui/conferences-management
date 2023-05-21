package ma.enset.conferencesmanagement.services;

import ma.enset.conferencesmanagement.dtos.ConferenceDto;
import ma.enset.conferencesmanagement.dtos.SessionDto;
import ma.enset.conferencesmanagement.entities.Conference;
import ma.enset.conferencesmanagement.entities.Session;

import java.util.List;
import java.util.Optional;

public interface ISessionConferenceService {
    public Conference addConference(ConferenceDto conferenceDto);
    public Session addSession(SessionDto sessionDto);
    public List<Conference> getAllConferences();
    public List<Session> getAllSession();
    public Optional<Conference> getConference(Long id);
    public Optional<Session> getSession(Long id);
    public void deleteConference(Long id);
    public void deleteSession(Long id);
    Session addConferenceToSession(Long idSession, Long idConference);
    Session addModerateurToSession(Long idSession, Long idModerateur);
    Session addSalleToSession(Long idSession, Long idSalle);
    Conference addSpeakerToConference(Long idConference, Long idSpeaker);
    //ConferenceDto addCommentaireToConference(Long idConference,Long idCommentaire);

}

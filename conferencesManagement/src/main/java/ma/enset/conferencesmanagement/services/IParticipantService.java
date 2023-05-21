package ma.enset.conferencesmanagement.services;

import ma.enset.conferencesmanagement.dtos.InviteDto;
import ma.enset.conferencesmanagement.dtos.ModerateurDto;
import ma.enset.conferencesmanagement.dtos.SpeakerDto;
import ma.enset.conferencesmanagement.entities.Moderateur;
import ma.enset.conferencesmanagement.entities.Participant;

import java.util.List;

public interface IParticipantService {
    public InviteDto addInvite(InviteDto inviteDto);
    List<InviteDto> getAllInvites();
    InviteDto getInvite(Long id);
    void deleteInvite(Long id);

    public Participant addSpeaker(SpeakerDto speakerDto);
    List<SpeakerDto> getAllSpeakers();
    SpeakerDto getSpeaker(Long id);
    void deleteSpeaker(Long id);

    public ModerateurDto addModerateur(ModerateurDto inviteDto);
    List<ModerateurDto> getAllModerateurs();
    List<Moderateur> getAllModerateurss();
    ModerateurDto getModerateur(Long id);
    void deleteModerateur(Long id);
}

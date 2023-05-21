package ma.enset.conferencesmanagement.web;

import ma.enset.conferencesmanagement.dtos.InviteDto;
import ma.enset.conferencesmanagement.dtos.ModerateurDto;
import ma.enset.conferencesmanagement.dtos.SpeakerDto;
import ma.enset.conferencesmanagement.entities.Moderateur;
import ma.enset.conferencesmanagement.entities.Participant;
import ma.enset.conferencesmanagement.services.impl.ParticipantServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParticipantController {
    private ParticipantServiceImpl participantService;

    public ParticipantController(ParticipantServiceImpl participantService) {
        this.participantService = participantService;
    }
    @PostMapping("/speakers")
    public Participant addSpeaker(SpeakerDto speakerDto){
        return participantService.addSpeaker(speakerDto);
    }
    @PostMapping("/moderateurs")
    public ModerateurDto addModerateur(ModerateurDto moderateurDto){
        return participantService.addModerateur(moderateurDto);
    }
    @PostMapping("/invites")
    public InviteDto addInvite(InviteDto inviteDto){
        return participantService.addInvite(inviteDto);
    }
    @GetMapping ("/moderateurs")
    public List<ModerateurDto> getModerateurs(){
        return participantService.getAllModerateurs();
    }
    @GetMapping ("/speakers")
    public List<SpeakerDto> getSpeaker(){
        return participantService.getAllSpeakers();
    }
    @GetMapping ("/invites")
    public List<InviteDto> getInvite(){
        return participantService.getAllInvites();
    }
    @GetMapping("/mods")
    List<Moderateur> getMods(){
        return participantService.getAllModerateurss();
    }
}

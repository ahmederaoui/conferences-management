package ma.enset.conferencesmanagement.mappers;

import ma.enset.conferencesmanagement.dtos.*;
import ma.enset.conferencesmanagement.entities.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ConferenceMappers {
    private ModelMapper modelMapper=new ModelMapper();

    public ConferenceDto fromConference(Conference conference){
        return modelMapper.map(conference,ConferenceDto.class);
    }
    public  Conference fromConferenceDto(ConferenceDto conferenceDto){
        return modelMapper.map(conferenceDto,Conference.class);
    }

    public SessionDto fromSession(Session session){
        return modelMapper.map(session,SessionDto.class);
    }
    public  Session fromSessionDto(SessionDto sessionDto){
        return modelMapper.map(sessionDto,Session.class);
    }

    public InscriptionDto fromInscription(Inscription inscription){
        return modelMapper.map(inscription,InscriptionDto.class);
    }
    public  Inscription fromInscriptionDto(InscriptionDto inscriptionDto){
        return modelMapper.map(inscriptionDto,Inscription.class);
    }

    public SpeakerDto fromSpeaker(Speaker speaker){
        return modelMapper.map(speaker,SpeakerDto.class);
    }
    public  Speaker fromSpeakerDto(SpeakerDto speakerDto){
        return modelMapper.map(speakerDto,Speaker.class);
    }

    public ModerateurDto fromModerateur(Moderateur moderateur){
        return modelMapper.map(moderateur,ModerateurDto.class);
    }
    public  Moderateur fromModerateurDto(ModerateurDto moderateurDto){
        return modelMapper.map(moderateurDto,Moderateur.class);
    }
    public InviteDto fromParticipant1(Participant participant){
        System.out.println(participant);
        return modelMapper.map(participant,InviteDto.class);
    }
    public  Participant fromInvite1Dto(InviteDto inviteDto){
        System.out.println(inviteDto);
        return modelMapper.map(inviteDto,Participant.class);
    }
    public InviteDto fromInvite(Invite invite){
        return modelMapper.map(invite,InviteDto.class);
    }
    public  Invite fromInviteDto(InviteDto inviteDto){
        return modelMapper.map(inviteDto,Invite.class);
    }

    public SalleDto fromSalle(Salle salle){
        return modelMapper.map(salle,SalleDto.class);
    }
    public  Salle fromSalleDto(SalleDto salleDto){
        return modelMapper.map(salleDto,Salle.class);
    }

    public ParticipantDto fromParticipant(Participant participant){
        return modelMapper.map(participant,ParticipantDto.class);
    }
    public  Participant fromParticipantDto(ParticipantDto participantDto){
        return modelMapper.map(participantDto,Participant.class);
    }

    public CommentaireDto fromCommentaire(Commentaire commentaire){
        return modelMapper.map(commentaire,CommentaireDto.class);
    }
    public  Commentaire fromCommentaireDto(CommentaireDto commentaireDto){
        return modelMapper.map(commentaireDto,Commentaire.class);
    }

}

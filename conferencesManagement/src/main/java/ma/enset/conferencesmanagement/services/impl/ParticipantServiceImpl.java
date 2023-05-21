package ma.enset.conferencesmanagement.services.impl;

import ma.enset.conferencesmanagement.dtos.InviteDto;
import ma.enset.conferencesmanagement.dtos.ModerateurDto;
import ma.enset.conferencesmanagement.dtos.SpeakerDto;
import ma.enset.conferencesmanagement.entities.Moderateur;
import ma.enset.conferencesmanagement.entities.Participant;
import ma.enset.conferencesmanagement.mappers.ConferenceMappers;
import ma.enset.conferencesmanagement.repositories.InviteRepository;
import ma.enset.conferencesmanagement.repositories.ModerateurRepository;
import ma.enset.conferencesmanagement.repositories.ParticipantRepository;
import ma.enset.conferencesmanagement.repositories.SpeakerRepository;
import ma.enset.conferencesmanagement.services.IParticipantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParticipantServiceImpl implements IParticipantService {
    private ConferenceMappers conferenceMapper;
    private InviteRepository inviteRepository;
    private SpeakerRepository speakerRepository;
    private ModerateurRepository moderateurRepository;
    private ParticipantRepository participantRepository;

    public ParticipantServiceImpl(ConferenceMappers conferenceMapper, InviteRepository inviteRepository, SpeakerRepository speakerRepository, ModerateurRepository moderateurRepository, ParticipantRepository participantRepository) {
        this.conferenceMapper = conferenceMapper;
        this.inviteRepository = inviteRepository;
        this.speakerRepository = speakerRepository;
        this.moderateurRepository = moderateurRepository;
        this.participantRepository = participantRepository;
    }


    @Override
    public InviteDto addInvite(InviteDto inviteDto) {
        return conferenceMapper.fromParticipant1(participantRepository.save(conferenceMapper.fromInvite1Dto(inviteDto))) ;
    }

    @Override
    public List<InviteDto> getAllInvites() {
        return participantRepository.findAll().stream()
                .map(conferenceMapper::fromParticipant1).collect(Collectors.toList());
    }

    @Override
    public InviteDto getInvite(Long id) {
        return conferenceMapper.fromInvite(inviteRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteInvite(Long id) {
        inviteRepository.deleteById(id);
    }

    @Override
    public Participant addSpeaker(SpeakerDto speakerDto) {
        return  participantRepository.save(conferenceMapper.fromParticipantDto(speakerDto));
    }

    @Override
    public List<SpeakerDto> getAllSpeakers() {
        return speakerRepository.findAll().stream()
                .map(conferenceMapper::fromSpeaker).collect(Collectors.toList());
    }

    @Override
    public SpeakerDto getSpeaker(Long id) {
        return conferenceMapper.fromSpeaker(speakerRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteSpeaker(Long id) {
        speakerRepository.deleteById(id);
    }

    @Override
    public ModerateurDto addModerateur(ModerateurDto moderateurDto) {
        return conferenceMapper.fromModerateur(moderateurRepository.save(conferenceMapper.fromModerateurDto(moderateurDto)));
    }

    @Override
    public List<ModerateurDto> getAllModerateurs() {
        return moderateurRepository.findAll().stream()
                .map(conferenceMapper::fromModerateur).collect(Collectors.toList());
    }

    @Override
    public List<Moderateur> getAllModerateurss() {
        return moderateurRepository.findAll();
    }

    @Override
    public ModerateurDto getModerateur(Long id) {
        return conferenceMapper.fromModerateur(moderateurRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteModerateur(Long id) {
        moderateurRepository.deleteById(id);
    }
}

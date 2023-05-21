package ma.enset.conferencesmanagement.security.services;


import ma.enset.conferencesmanagement.entities.AppRole;
import ma.enset.conferencesmanagement.entities.Participant;
import ma.enset.conferencesmanagement.security.repositories.AppRoleRepository;
import ma.enset.conferencesmanagement.security.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AppServiceImpl implements IAppService{
    private AppRoleRepository appRoleRepository;
    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;

    public AppServiceImpl(AppRoleRepository appRoleRepository, AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appRoleRepository = appRoleRepository;
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Participant addNewUser(Participant participant) {
        String password = participant.getPassword();
        participant.setPassword(passwordEncoder.encode(password));
        return appUserRepository.save(participant);
    }

    @Override
    public Participant getUser(String userName) {
        return appUserRepository.findByUserName(userName);
    }

    @Override
    public Participant addRoleToUser(String roleName, String userName) {
        Participant user = appUserRepository.findByUserName(userName);
        AppRole role  = appRoleRepository.findByRoleName(roleName);
        user.getUserRoles().add(role);
        return user;
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public List<Participant> userList() {
        return appUserRepository.findAll();
    }
}

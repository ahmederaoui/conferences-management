package ma.enset.conferencesmanagement.security.services;


import ma.enset.conferencesmanagement.entities.AppRole;
import ma.enset.conferencesmanagement.entities.Participant;

import java.util.List;

public interface IAppService {
    Participant addNewUser(Participant participant);
    Participant getUser(String userName);
    Participant addRoleToUser(String roleName, String UserName);
    AppRole addNewRole(AppRole appRole);
    List<Participant> userList();

}

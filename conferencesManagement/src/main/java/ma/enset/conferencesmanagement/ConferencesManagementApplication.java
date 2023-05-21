package ma.enset.conferencesmanagement;

import ma.enset.conferencesmanagement.entities.AppRole;
import ma.enset.conferencesmanagement.entities.Participant;
import ma.enset.conferencesmanagement.security.services.AppServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ConferencesManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferencesManagementApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner commandLineRunner(AppServiceImpl appService){
        return args -> {
            appService.addNewRole(new AppRole(null,"USER"));
            appService.addNewRole(new AppRole(null,"ADMIN"));
            appService.addNewRole(new AppRole(null,"RESPONSABLE"));
            appService.addNewRole(new AppRole(null,"MANAGER"));
            appService.addNewRole(new AppRole(null,"FINANCIER"));

            appService.addNewUser(new Participant(null,"eraoui","eraoui",new ArrayList<>(),null,null,null,null));
            appService.addNewUser(new Participant(null,"el hanafi","el hanafi",new ArrayList<>(),null,null,null,null));
            appService.addNewUser(new Participant(null,"nedday","nedday",new ArrayList<>(),null,null,null,null));
            appService.addNewUser(new Participant(null,"mansouri","mansouri",new ArrayList<>(),null,null,null,null));

            appService.addRoleToUser("USER","eraoui");
            appService.addRoleToUser("ADMIN","eraoui");
            appService.addRoleToUser("RESPONSABLE","el hanafi");
            appService.addRoleToUser("MANAGER","el hanafi");
            appService.addRoleToUser("RESPONSABLE","nedday");
            appService.addRoleToUser("USER","nedday");
            appService.addRoleToUser("FINANCIER","mansouri");


        };
    }
}

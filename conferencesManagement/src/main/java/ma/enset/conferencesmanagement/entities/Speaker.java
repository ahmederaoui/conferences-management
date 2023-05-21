package ma.enset.conferencesmanagement.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Speaker extends Participant {
    private String profilProfessionnel;
    @OneToMany(mappedBy = "speaker")
    private List<Conference> conferences;
}

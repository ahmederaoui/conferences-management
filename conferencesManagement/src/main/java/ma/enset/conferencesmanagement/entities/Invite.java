package ma.enset.conferencesmanagement.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Invite extends Participant {
    private String affiliation;
    @ManyToMany(mappedBy = "invites")
    private List<Inscription> inscriptions;
}

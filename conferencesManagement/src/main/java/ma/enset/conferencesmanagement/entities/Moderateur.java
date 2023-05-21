package ma.enset.conferencesmanagement.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Moderateur extends Participant {
    private String specialite;
    @OneToMany(mappedBy = "moderateur",fetch = FetchType.LAZY)
    private List<Session> sessions;
}


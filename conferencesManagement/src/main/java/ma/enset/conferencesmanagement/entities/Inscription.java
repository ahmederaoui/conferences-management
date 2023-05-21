package ma.enset.conferencesmanagement.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String statut;
    private double prix;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Invite> invites;
    @ManyToOne
    private Session session;

}

package ma.enset.conferencesmanagement.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private Date date;
    private Time heureDebut;
    private Time heureFin;
    private String description;

    @ManyToOne
    private Session session;

    @ManyToOne(fetch = FetchType.LAZY)
    private Speaker speaker;

    @OneToMany(mappedBy = "conference")
    private List<Commentaire> commentaires;

    // Constructeurs, getters et setters
}


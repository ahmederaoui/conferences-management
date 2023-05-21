package ma.enset.conferencesmanagement.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class ConferenceDto {
    private Long id;
    private String titre;
    private Date date;
    private Time heureDebut;
    private Time heureFin;
    private String description;
    private SessionDto sessionDto;
    private SpeakerDto speakerDto;
    private List<CommentaireDto> commentaireDtos;
}


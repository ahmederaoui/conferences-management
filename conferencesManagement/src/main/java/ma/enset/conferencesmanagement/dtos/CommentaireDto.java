package ma.enset.conferencesmanagement.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class CommentaireDto {
    private Long id;
    private Date date;
    private String contenu;
    private int likes;
    private ParticipantDto participantDto;
    private ConferenceDto conferenceDto;
}

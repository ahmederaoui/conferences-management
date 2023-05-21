package ma.enset.conferencesmanagement.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.conferencesmanagement.enums.Genre;

@Data @AllArgsConstructor @NoArgsConstructor
public class ParticipantDto {
    private Genre genre;
}
package ma.enset.conferencesmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class InviteDto extends ParticipantDto {
    private Long id;
    private String nom;
    private String email;
    private String affiliation;
}

package ma.enset.conferencesmanagement.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class InscriptionDto {
    private Long id;
    private Date date;
    private String statut;
    private double prix;
    private List<InviteDto> inviteDtos;
    private SessionDto sessionDto;

}

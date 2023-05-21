package ma.enset.conferencesmanagement.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class SessionDto {
    private Long id;
    private String nom;
    private List<ConferenceDto> conferenceDtos;
    private ModerateurDto moderateurDto;
    private SalleDto salleDto;
}

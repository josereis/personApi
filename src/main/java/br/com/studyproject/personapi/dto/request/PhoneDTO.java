package br.com.studyproject.personapi.dto.request;

import br.com.studyproject.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {
    private long id;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;

    @Enumerated(EnumType.STRING)
    private PhoneType type;
}

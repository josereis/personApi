package br.com.studyproject.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private long id;

    @NotEmpty
    @CPF
    private String cpf;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String name;

    @NotEmpty
    @Valid
    private List<PhoneDTO> phones;

    private String birthDate;
}

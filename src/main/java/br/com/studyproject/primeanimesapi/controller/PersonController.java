package br.com.studyproject.primeanimesapi.controller;

import br.com.studyproject.primeanimesapi.dto.MessageResponseDTO;
import br.com.studyproject.primeanimesapi.dto.request.PersonDTO;
import br.com.studyproject.primeanimesapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PersonDTO personDTO) {
        return personService.create(personDTO);
    }
}

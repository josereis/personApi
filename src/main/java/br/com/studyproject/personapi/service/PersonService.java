package br.com.studyproject.personapi.service;

import br.com.studyproject.personapi.dto.MessageResponseDTO;
import br.com.studyproject.personapi.dto.request.PersonDTO;
import br.com.studyproject.personapi.exception.PersonNotFoundException;
import br.com.studyproject.personapi.mapper.PersonMapper;
import br.com.studyproject.personapi.model.Person;
import br.com.studyproject.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();

        return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public MessageResponseDTO create(PersonDTO personDTO) {
        var personToSave = personMapper.toModel(personDTO);
        var createdPerson = personRepository.save(personToSave);

        return MessageResponseDTO.builder().message("Create Person with ID " + createdPerson.getId()).build();
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        var person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }
}

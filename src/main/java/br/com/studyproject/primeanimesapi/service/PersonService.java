package br.com.studyproject.primeanimesapi.service;

import br.com.studyproject.primeanimesapi.dto.MessageResponseDTO;
import br.com.studyproject.primeanimesapi.dto.request.PersonDTO;
import br.com.studyproject.primeanimesapi.mapper.PersonMapper;
import br.com.studyproject.primeanimesapi.model.Person;
import br.com.studyproject.primeanimesapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}

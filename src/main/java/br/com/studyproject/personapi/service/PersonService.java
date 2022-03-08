package br.com.studyproject.personapi.service;

import br.com.studyproject.personapi.dto.MessageResponseDTO;
import br.com.studyproject.personapi.dto.request.PersonDTO;
import br.com.studyproject.personapi.exception.PersonNotFoundException;
import br.com.studyproject.personapi.mapper.PersonMapper;
import br.com.studyproject.personapi.model.Person;
import br.com.studyproject.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

   public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();

        return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public MessageResponseDTO create(PersonDTO personDTO) {
        var personToSave = personMapper.toModel(personDTO);
        var createdPerson = personRepository.save(personToSave);

        return createMessageResponseDTO("Create Person with ID ", createdPerson.getId());
    }

    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExist(id);

        var personToUpdate = personMapper.toModel(personDTO);
        var updatedPerson = personRepository.save(personToUpdate);

        return createMessageResponseDTO("Updated Person with ID ", updatedPerson.getId());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        var person = verifyIfExist(id);

        return personMapper.toDTO(person);
    }

    public void delete(long id) throws PersonNotFoundException {
        verifyIfExist(id);
        personRepository.deleteById(id);
    }

    private Person verifyIfExist(long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponseDTO(String message, long id) {
        return MessageResponseDTO.builder().message(message + id).build();
    }
}

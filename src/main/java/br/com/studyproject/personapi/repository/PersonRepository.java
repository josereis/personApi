package br.com.studyproject.personapi.repository;

import br.com.studyproject.personapi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

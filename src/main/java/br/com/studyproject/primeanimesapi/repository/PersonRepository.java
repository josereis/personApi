package br.com.studyproject.primeanimesapi.repository;

import br.com.studyproject.primeanimesapi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

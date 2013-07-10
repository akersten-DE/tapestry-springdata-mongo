package de.kersten.tapestryspring.services.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import de.kersten.tapestryspring.domain.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, String> {

}

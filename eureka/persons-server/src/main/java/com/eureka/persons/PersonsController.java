package com.eureka.persons;

import com.eureka.persons.ex.NotFoundException;
import com.eureka.persons.person.Person;
import com.eureka.persons.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/persons")
public class PersonsController {


    private PersonService personService;

    @Autowired
    public PersonsController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Handles requests to list all persons.
     */
    //TODO find all persons using the functions already implemented and sort them by id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> list() {
        return personService.findAll().stream().sorted(Person.COMPARATOR_BY_ID).collect(Collectors.toList());
    }

    /**
     * Handles requests to create a person.
     */
    //TODO save a person to the db or throw PersonsException
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/create")
    public void create(@RequestBody Person person, BindingResult result) throws PersonsException {
        if (result.hasErrors()) {
            throw new PersonsException(HttpStatus.BAD_REQUEST, new BindException(result));
        } else {
            personService.save(person);
        }
    }

    /**
     * Returns the {@code Person} instance with id {@code id}
     *
     * @param id
     * @return
     */
    //TODO find a person by id or throw NotFoundException
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/show/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person show(@PathVariable Long id) {
        Person p = personService.findById(id).orElseThrow(()->new NotFoundException(Person.class, id));
        return p;
    }

    /**
     * Updates the {@code Person} instance with id {@code id}
     *
     * @param updatedPerson
     * @param id
     * @return
     */
    //TODO update an existing person if found else throw NotFoundException
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    public void update(@RequestBody Person updatedPerson, @PathVariable Long id) {
        Person p = personService.findById(id).orElseThrow(() -> new NotFoundException(Person.class, id));
        p.setUsername(updatedPerson.getUsername());
        p.setPassword(updatedPerson.getPassword());
        p.setFirstName(updatedPerson.getFirstName());
        p.setLastName(updatedPerson.getLastName());
        p.setHiringDate(updatedPerson.getHiringDate());
        personService.save(p);
    }

    /**
     * Delete the {@code Person} instance with id {@code id}
     *
     * @param id
     */
    //TODO delete a person
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        Person p = personService.findById(id).orElseThrow(() -> new NotFoundException(Person.class, id));
        personService.delete(p);
    }
}
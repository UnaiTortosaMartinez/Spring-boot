package com.concretepage.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.concretepage.domain.Employee;
import com.concretepage.service.EmployeeService;
@RestController
public class EmployeeController {
    @Autowired private PersonService personService;

    @Autowired private PersonRepository personRepository;

    @RequestMapping(value = "/persistPerson", method = RequestMethod.POST)
    public ResponseEntity < String > persistPerson(@RequestBody PersonDTO person) {
        if (personService.isValid(person)) {
            personRepository.persist(person);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
} 
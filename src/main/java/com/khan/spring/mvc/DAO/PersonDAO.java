package com.khan.spring.mvc.DAO;

import com.khan.spring.mvc.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(1, "Kardan"));
        people.add(new Person(2, "Apti"));
        people.add(new Person(3,"Bob"));
        people.add(new Person(4, "Jenya"));

    }
    public List<Person> index () {
        return people;
    }
    public Person show (int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}

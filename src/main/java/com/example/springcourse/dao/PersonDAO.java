package com.example.springcourse.dao;

import com.example.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private final List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Ilya", 18, "ilya500514@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Dimooon", 30, "dimooonARA@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Vadim", 16, "efremenko@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Arseniy", 18, "demidchik2003@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Vladooos", 19, "vlados@mail.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}

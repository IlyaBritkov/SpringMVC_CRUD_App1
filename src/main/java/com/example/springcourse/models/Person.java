package com.example.springcourse.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    @NotEmpty(message = "Name field should not be empty")
    @Size(min = 2, max = 32, message = "Message should be between 2 and 32 characters")
    private String name;
    @Getter
    @Setter
    @Min(value = 0, message = "Age should be greater, than zero")
    private int age;
    @Getter
    @Setter
    @NotEmpty(message = "Email field should not be empty")
    @Email(message = "That email is not exist")
    private String email;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}

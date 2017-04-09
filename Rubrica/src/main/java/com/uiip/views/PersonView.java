package com.uiip.views;

import com.uiip.models.PersonModel;

public class PersonView {

    private PersonModel person;

    public PersonView(PersonModel person) {
        this.person = person;
    }

    public void printInfo() {
        System.out.println(person);
    }

    public PersonModel getPerson() {
        return person;
    }

    public void setPerson(PersonModel person) {
        this.person = person;
    }

}

package com.uiip.controllers;

import com.uiip.models.PersonModel;
import com.uiip.views.PersonView;

public class PersonController {

    private PersonModel personModel;
    private PersonView personView;

    public PersonController(PersonModel personModel, PersonView personView) {
        this.personModel = personModel;
        this.personView = personView;
    }

    public void updateView(PersonModel personModel) {
        personView.setPerson(personModel);
    }

    public void updateModel(PersonView personView) {

        this.personModel = personView.getPerson();
    }

    public PersonView getPersonView() {
        return personView;
    }

    public void setPersonView(PersonView personView) {
        this.personView = personView;
    }

    public PersonModel getPersonModel() {
        return personModel;
    }

    public void setPersonModel(PersonModel personModel) {
        this.personModel = personModel;
    }

}

package com.uiip.interfaces;

import com.uiip.models.PersonModel;

public interface PersonDAO {

    public PersonModel getPersonInfo(String phoneNumber);

    public boolean updatePersonInfo(String phoneNumber, String city);

    public boolean insertPerson(PersonModel personModel, String nomePhone);

    public boolean deletePerson(String phoneNumber);
}

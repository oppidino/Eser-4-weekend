package com.uiip.models;

public class PersonModel {

    private String name, surname, date, phoneNumber, city;
    private PhoneModel model;

    public PersonModel() {
    }

    public PersonModel(String name, String surname, String date, String city, String phoneNumber, PhoneModel model) {
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.city=city;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public PhoneModel getModel() {
        return model;
    }

    public void setModel(PhoneModel model) {
        this.model = model;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ").append(name).append("\n")
                .append("Surname: ").append(surname).append("\n")
                .append("Date: ").append(date).append("\n")
                .append("City: ").append(city).append("\n")
                .append("Phone number: ").append(phoneNumber).append("\n")
                .append("Model: ").append(model.getName());
        return builder.toString();
    }

}

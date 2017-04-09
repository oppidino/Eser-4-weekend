package com.uiip;

import com.uiip.controllers.InputControl;
import com.uiip.controllers.PersonController;
import com.uiip.interfaces.PersonDAO;
import com.uiip.interfaces.PhoneDAO;
import com.uiip.interfaces.impl.DefaultPersonDAO;
import com.uiip.interfaces.impl.DefaultPhoneDAO;
import com.uiip.models.PersonModel;
import com.uiip.models.PhoneModel;
import com.uiip.views.PersonView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class App {

    public static void main(String[] args) {
        try {
            int scelta;
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in, Charset.defaultCharset()));
            PersonModel personModel = new PersonModel();
            PhoneModel phoneModel = new PhoneModel();
            String tipo, name, surname, city, phoneNumber, brand, opsys, date, model;
            PersonView personView = new PersonView(personModel);
            PersonController personController = new PersonController(personModel, personView);
            do {
                System.out.println("RUBRICA\n");
                System.out.println("1--> Inserisci un Utente: ");
                System.out.println("2--> Inserisci Telefono: ");
                System.out.println("3--> Aggiorna la citta di un Utente: ");
                System.out.println("4--> Cerca Utente: ");
                System.out.println("5--> Cancella Utente: ");
                System.out.println("0--> per Uscire... ");
                scelta = InputControl.parseNumber(input);
                switch (scelta) {
                    case 1:
                    {
                    	personModel = new PersonModel();
                    	System.out.print("Inserisci il Numero di Telefono della persona: ");
                    	phoneNumber = InputControl.insert(input);
                    	personModel.setPhoneNumber(phoneNumber);
                    	System.out.print("Inserisci il Nome della persona: ");
                        name = InputControl.insert(input);
                        personModel.setName(name);
                        System.out.print("Inserisci il Cognome della persona: ");
                        surname = InputControl.insert(input);
                        personModel.setSurname(surname);
                        System.out.print("Inserisci la data di nascita della persona (yyyy-mm-dd): ");
                        date = InputControl.insert(input);
                        personModel.setDate(date);
                        System.out.print("Inserisci la Citta della persona: ");
                        city = InputControl.insert(input);
                        personModel.setCity(city);
                        System.out.print("Inserisci il Tipo di Telefono dell'Utente: ");
                        model = InputControl.insert(input);
                        phoneModel = getPhoneFromDB(model);
                        if (phoneModel != null) {
                            personModel.setModel(phoneModel);
                            if (insertUser(personModel, model)) {
                                System.out.println("L'Utente è stato inserito correttamente!");
                            } else {
                                System.out.println("Errore nell'inserimento dei dati. Utente non inserito!");
                            }
                        } else {
                            System.out.println("Telefono non presente.");
                        }
                    } break;
                    case 2:
                    {
                    	phoneModel = new PhoneModel();
                    	System.out.print("Inserisci il Tipo di cellulare: ");
                        tipo = InputControl.insert(input);
                        phoneModel.setName(tipo);
                        System.out.print("Inserisci il Brand del cellulare: ");
                        brand = InputControl.insert(input);
                        phoneModel.setBrand(brand);
                        System.out.print("Inserisci il Sistema Operativo del cellulare: ");
                        opsys = InputControl.insert(input);
                        phoneModel.setOpsys(opsys);
                        if (insertPhone(phoneModel)) {
                            System.out.println("Il Telefono è stato inserito correttamente!");
                        } else {
                            System.out.println("Errore nell'inserimento dei dati. Telefono non inserito!");
                        }
                    } break;
                    case 3:
                    {
                    	System.out.print("Inserisci il numero di telefono dell'Utente da aggiornare: ");
                    	phoneNumber = InputControl.insert(input);
                    	System.out.print("Inserisci la nuova citta: ");
                        city = InputControl.insert(input); 
                        if (updateUser(phoneNumber, city)) {
                            personModel = getPersonFromDB(phoneNumber);
                            personController.setPersonModel(personModel);
                            personController.updateView(personModel);
                            System.out.println("Utente aggiornato:");
                            personView.printInfo();
                        } else {
                            System.out.println("Questo numero di telefono non è salvato in rubrica");
                        }
                    } break;
                    case 4:
                    {
                    	System.out.print("Inserisci il numero di telefono dell'Utente da ricercare: ");
                    	phoneNumber = InputControl.insert(input);
                        personModel = getPersonFromDB(phoneNumber);
                        if (personModel != null) {
                            personController.setPersonModel(personModel);
                            personController.updateView(personModel);
                            personView.printInfo();
                        } else {
                            System.out.println("Il numero di telefono non è stato trovato!");
                        }
                    } break;
                    case 5:
                    {
                    	System.out.print("Inserisci il numero di telefono dell'Utente da cancellare: ");
                    	phoneNumber = InputControl.insert(input);
                        if (deleteUserFromDB(phoneNumber)) {
                            System.out.println("L'Utente è stato cancellato correttamente");
                        } else {
                            System.out.println("Non è possibile cancellare l'Utente. Il numero di telefono non è stato trovato!");
                        }
                    } break;
                    case 0:
                    {
                        System.out.println("Si è deciso di uscire...");
                    } break;
                    default:
                    {
                        System.out.println("Inserisci una scelta da 0 a 6!");
                    } break;
                }
            } while (scelta != 0);
        } catch (IOException ex) {
      }
    }

    private static boolean insertUser(PersonModel personModel, String model) {
        PersonDAO personDAO = new DefaultPersonDAO();
        return personDAO.insertPerson(personModel, model);
    }
    
    private static boolean insertPhone(PhoneModel phoneModel) {
        PhoneDAO phoneDAO = new DefaultPhoneDAO();
        return phoneDAO.insertPhone(phoneModel);
    }
    
    private static boolean updateUser(String personModel, String city) {
        PersonDAO personDAO = new DefaultPersonDAO();
        return personDAO.updatePersonInfo(personModel, city);
    }

    private static PersonModel getPersonFromDB(String phoneNumber) {
        PersonDAO personDAO = new DefaultPersonDAO();
        return personDAO.getPersonInfo(phoneNumber);
    }

    private static PhoneModel getPhoneFromDB(String tipo) {
        PhoneDAO phoneDAO = new DefaultPhoneDAO();
        return phoneDAO.getPhoneInfo(tipo);
    }

    private static boolean deleteUserFromDB(String phoneNumber) {
        PersonDAO personDAO = new DefaultPersonDAO();
        return personDAO.deletePerson(phoneNumber);
    }
}

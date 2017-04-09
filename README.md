# Eser-4-weekend

Il git flow da me seguito è così strutturato: 
dal branch master ho creato un branch develop. Da quest’ultimo ho creato un progetto maven, utile per gestire le dipendenze delle librerie usate e sono andato a modificare il file “.gitignore”, così da escludere determinati file (.classpath, .project, .settings, target). Dal ramo di develop ho sviluppato un ulteriore ramo di nome release1.0 e da qui ho creato le features di sviluppo relativi alle views, ai models, ai controllers, alle interfaces, al main e al database.
Ognuno dei branch feature ha sviluppato parti differenti del progetto.
Alla fine di ogni singolo sviluppo da parte dei branch, i files relativi ad ogni feature sono stati inclusi nel branch release con un merge. 
In questo punto release aveva al suo interno il progetto completo pronto ad essere pubblicato. Quest’ultimo è stato unificato prima con develop e poi con master per la pubblicazione. Da master è stato creato un tag di versione (version1.0) ed infine sono stati cancellati tutti i branch di sviluppo compreso release1.0 ed escluso develop.
Per sviluppare il progetto è stato seguito il pattern architetturale model view control.
Sono state create 2 classi PersonModel e PhoneModel che rappresentano il modello; 2 classi chiamate PersonView e PhoneView che rappresentano le viste, e 2 classi PersonController e InputController che rappresentano i controllori. Quest’ultimo (InputController) rappresenta i controlli da tastiera e non è realtivo al model view control.
Nella classe PersonModel ho inserito un riferimento alla classe PhoneModel, tale da rappresentare il collegamento delle  tabelle Telefono e Persona.
Successivamente ho creato 2 interfacce seguendo lo schema del pattern DAO relative alle interrogazioni al database. Tali metodi sono stati implementati nelle classi DefaultPhoneDAO e DefaultPersonDAO. Oltre alle query per interrogare il database viene gestita anche la connessione.
Infine è stato sviluppato il Menu testuale con cui l’Utente può gestire l’ applicazione.

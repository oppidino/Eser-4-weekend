# Eser-4-weekend

Il git flow da me seguito è così strutturato: dal branch master ho creato un branch develop. Dal develop ho creato un progetto maven e sono andato a modificare il file “.gitignore”, così da escludere determinati file (.classpath, .project, .settings, target). Dal ramo di develop ho sviluppato un ulteriore ramo di nome release1.0. Dal release ho creato le feature di sviluppo relativi alle views, ai models, ai controllers, alle interfaces, al main e al database.
Ognuno dei branch feature ha sviluppato parti differenti del progetto.
Alla fine di ogni signolo sviluppo i files relativi ad ogni features sono stati inclusi in release con un merge. 
In questo punto release aveva al suo interno il progetto completo. Quest’ultimo è stato unificato prima con develop e poi con master per la pubblicazione. Da master è stato creato un tag di versione (version1.0) ed infine sono stati cancellati tutti i branch di sviluppo escluso develop.
Per sviluppare il progetto è stato seguito il pattern architetturale model view control.
Sono state create 2 classi PersonModel e PhoneModel che rappresentano il modello; 2 classi chiamate PersonView e PhoneView che rappresentano le viste, e 2 classi PersonController e InputController che rappresentano i controllori. Quest’ultimo (InputController) rappresenta i controlli di input da tastiera da parte dell’utente.
Nella classe PersonModel ho inserito un riferimento alla classe PhoneModel, tale da rappresentare il collegamento delle  tabelle Telefono e Persona.
Successivamente ho creato 2 interfacce seguendo lo schema del pattern DAO relativi alle interrogazioni al database. Tali metodi sono stati sviluppati nelle classi DefaultPhoneDAO e DefaultPersonDAO. Oltre alle query per interrogare il database viene gestita anche la connessione.
Infine è stato sviluppato il Menu testuale con cui l’Utente può gestire l’ applicazione.
Nel progetto è stato utilizzato Maven utile per gestire le dipendenze delle librerie usate.

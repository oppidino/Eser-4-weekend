use Rubrica;

insert into telefono (id, tipo, brand, opsys) values(1,"HTC One M8","HTC","Android");
insert into telefono (id, tipo, brand, opsys) values(2,"Iphone 5S","Apple","iOS");
insert into telefono (id, tipo, brand, opsys) values(3,"Lumia 520","Microsoft","Windows Phone");
insert into telefono (id, tipo, brand, opsys) values(4,"Galaxy S8","Samsung","Android");
insert into telefono (id, tipo, brand, opsys) values(5,"One Plus One","One Plus","Android");
insert into telefono (id, tipo, brand, opsys) values(6,"Huawei P9","Huawei","Android");
insert into telefono (id, tipo, brand, opsys) values(7,"Xiamoi Mi","Xiami","Android");
insert into telefono (id, tipo, brand, opsys) values(8,"Iphone 6S","Apple","iOS");
insert into telefono (id, tipo, brand, opsys) values(9,"Iphone 7","Apple","iOS");
insert into telefono (id, tipo, brand, opsys) values(10,"One Plus Three","One Plus","Android");
insert into telefono (id, tipo, brand, opsys) values(11,"Galaxy S5","Samsung","Android");


#inserimento di un nuovo utente

insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3333333333", "Remo", "La Barca", '1990-03-23',"Milano", 2);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3343689827", "Assunata", "Licenziata", '1954-01-10',"Roma", 5);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3458909267", "Rocco", "Tano", '1978-06-05',"Taranto", 3);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3334567290", "Vittorio", "Schiavone", '1993-04-25',"Ariano Irpino", 3);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3331245098", "Alessandro", "Orioli", '1985-11-19',"Napoli", 6);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3335629931", "Giuseppe", "Grasso", '1983-10-10',"Milano", 7);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3339067938", "Alessandro", "Di Gruttola", '1982-09-19',"Roma", 1);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3333389098", "Giovanni", "Viviani", '1985-09-20',"Napoli", 2);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3333387456", "Margherita", "Schiavone", '1990-05-15',"Roma", 3);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3332992299", "Maria", "Fava", '1994-11-17',"Milano", 8);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3331090573", "Anna", "Vacca", '1976-01-13',"Napoli", 10);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3332859287", "Giovanni", "Gianni", '1957-03-05',"Torino", 11);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3336532482", "Michele", "Merluzzo", '1989-03-27',"Roma", 10);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3336271937", "Guido", "La Vespa", '1994-10-10',"Milano", 11);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3332345237", "Pierpaolo", "Pasolini", '1994-06-27',"Milano", 1);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3332227843", "Antonio", "Verdi", '1990-02-18',"Napoli", 2);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3331903692", "Mario", "Rossi", '1986-08-08',"Bologna", 2);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3334544564", "Mario", "Pri", '1989-08-25',"Torino", 3);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3338762382", "Gina", "Cande", '1983-12-25',"Termoli", 5);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3334445836", "Felice", "Evacuo", '1982-01-06',"Napoli", 8);
insert into persona (numero_tel, nome, cognome, data_nascita, citta, modello) values("3333777349", "Fortunato", "Gnomo", '1941-01-01',"Pordenone", 9);


#Visualizzazione delle informazioni anagrafiche e del modello di telefono posseduto

select p.nome, p.cognome, p.data_nascita, p.citta, t.tipo
from persona p, telefono t
where p.modello=t.id;


#Update sia delle informazioni anagrafiche che del telefono (decidete voi a priori quali)

UPDATE persona p join telefono t on p.modello=t.id
SET p.citta = "Bolzano", t.tipo="Xiamoi Mi 4"
WHERE p.numero_tel="3335629931";


#Visualizzazioni delle informazioni relative ai telefoni

select count(p.numero_tel), t.tipo, t.brand, t.opsys
from persona p, telefono t
where p.modello=t.id
group by t.tipo
order by count(p.numero_tel) desc;


#Visualizzazioni delle informazioni relative al telefono Iphone

select count(p.numero_tel), t.tipo, t.brand, t.opsys
from persona p, telefono t
where p.modello=t.id and t.tipo like 'Iphone%'
group by t.tipo
order by count(p.numero_tel) desc;
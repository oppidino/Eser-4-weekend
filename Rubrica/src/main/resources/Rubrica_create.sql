drop database if exists Rubrica;

create database if not exists Rubrica;

use Rubrica;

drop table if exists telefono;

create table telefono(
id int(2) not null auto_increment,
tipo varchar(64),
brand varchar(32),
opsys varchar(32),
primary key (id)
);

drop table if exists persona;

create table persona(
numero_tel varchar(20) not null,
nome varchar(32) not null,
cognome varchar(32),
data_nascita date,
citta varchar(32),
modello int(2) not null,
primary key (numero_tel),
constraint fk_modello foreign key (modello) references telefono(id)
);

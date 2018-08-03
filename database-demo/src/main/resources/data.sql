/*Create statement is not needed for JPA as if using memory database it will be 
automatically created. If not it will show error as table already created.
Just for JDBC we need to uncomment and use the table below for h2.
*/

/*
create table person
(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   primary key(id)
);
*/


INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10001,  'Ranga', 'Hyderabad',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10002,  'James', 'New York',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10003,  'Pieter', 'Amsterdam',sysdate());


/*1.SQL Command to be executed in MYSQL , for initial table creation and insertion, only one time*/

/*
show variables like '%time_zone%';

select now();

create table person
(
	id integer not null AUTO_INCREMENT,
	birth_date timestamp,
	location varchar(255),
	name varchar(255),
	primary key (id)
);

INSERT INTO PERSON (NAME, LOCATION, BIRTH_DATE ) VALUES('Raju', 'Malaysia',sysdate());
INSERT INTO PERSON (NAME, LOCATION, BIRTH_DATE ) VALUES('Baju', 'Indonesia',sysdate());
INSERT INTO PERSON (NAME, LOCATION, BIRTH_DATE ) VALUES('Keju', 'Italy',sysdate());


ALTER TABLE person AUTO_INCREMENT=1;
*/
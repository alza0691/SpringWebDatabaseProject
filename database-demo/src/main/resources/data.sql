/*Create statement is not needed for JPA as if using memory database it will be 
automatically created. If not it will show error as table already created.
Just for JDBC we need to uncomment and use the table below.
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
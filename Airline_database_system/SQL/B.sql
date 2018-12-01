CREATE TABLE aircrafts (
ac_id varchar2(8) ,
model_no varchar2(15),
capacity number ,
mfd_by varchar2(10),
mfd_on varchar2(15) ,
PRIMARY KEY(ac_id)
);

insert into aircrafts values('C-32A','Boeing 757',120,'Boeing','01-JUN-1998');
insert into aircrafts values('C-32','Boeing 757',100,'Boeing','01-AUG-1996');
insert into aircrafts values('A-318','Airbus A318',107,'Airbus','15-JAN-2002');
insert into aircrafts values('A-350','Airbus A350',300,'Airbus','15-JUL-2013');
insert into aircrafts values('N4744','Boeing 727',100,'Boeing','20-JAN-1990');
insert into aircrafts values('E-195','Embraer 195',122,'Embraer','01-JAN-2010');
insert into aircrafts values('C-FEJP','Embraer 195',122,'Embraer','08-JULY-2014');
insert into aircrafts values('A-330','Airbus A330',130,'Airbus','22-MAY-2009');
insert into aircrafts values('H-X','Airbus A380',150,'Airbus','15-JAN-2010');
insert into aircrafts values('G-X','Airbus A380',140,'Airbus','15-JAN-2014');
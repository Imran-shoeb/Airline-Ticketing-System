insert into aircrafts values('C-32A','Boeing 757',120,'Boeing','01-JUN-1998');
insert into aircrafts values('C-32','Boeing 757',100,'Boeing','01-AUG-1996');
insert into aircrafts values('A-318','Airbus A318',107,'Airbus','15-JAN-2002');
insert into aircrafts values('A-350','Airbus A350',300,'Airbus','15-JUL-2013');
insert into aircrafts values('E-195','Embraer 195',122,'Embraer','01-JAN-2010');
insert into aircrafts values('C-FEJP','Embraer 195',122,'Embraer','08-JULY-2014');

insert into flight values('F1','Dhaka','Paris','10AM','01-JAN-2015','2PM','01-JAN-2015','A-318');
insert into flight values('F2','Dhaka','Sydney','07AM','01-JAN-2015','10PM','01-JAN-2015','A-350');
insert into flight values('F6','Dhaka','Sydney','07AM','01-JUL-2015','10PM','01-JUL-2015','C-32');
insert into flight values('F7','Dhaka','London','08AM','01-JUL-2015','11PM','01-JUL-2015','C-32A');
insert into flight values('F9','Dhaka','LA','08AM','10-JAN-2015','11PM','10-JAN-2015','C-FEJP');
insert into flight values('F10','Dhaka','Jedda','09AM','02-JAN-2015','11PM','02-JAN-2015','E-195');

insert into customers values('C-100','Jon','Paris,Franch',49,02210000000);
insert into customers values('C-101','Tawsif','Dhaka,Bangladesh',25,01610000001);
insert into customers values('C-102','Maria','Dhaka,Bangladesh',45,01610000002);
insert into customers values('C-104','Eva','Dhaka,Bangladesh',25,01710000050);
insert into customers values('C-106','Akib','Dhaka,Bangladesh',25,01610000001);
insert into customers values('C-107','Abir','Mumbai,India',35,01610000041);
insert into customers values('C-108','Sneha','London,UK',24,01610000000);
insert into customers values('C-109','kabir','London,UK',32,01610000000);

insert into passengers values('P-100','kabir','London,UK',32,01610000077,'C-109');
insert into passengers values('P-101','Asif','London,UK',22,01610000060,'C-109');
insert into passengers values('P-102','Diya','London,UK',24,01610000034,'C-109');
insert into passengers values('P-103','Tawsif','Dhaka,Bangladesh',25,01610000001,'C-101');
insert into passengers values('P-104','Jovan','Dhaka,Bangladesh',30,01610000022,'C-101');
insert into passengers values('P-105','Akib','Dhaka,Bangladesh',25,01610000001,'C-106');
insert into passengers values('P-106','Abir','Mumbai,India',35,01610000041,'C-107');
insert into passengers values('P-107','Nabila','Mumbai,India',31,01610000011,'C-107');
insert into passengers values('P-108','Eva','Dhaka,Bangladesh',25,01710000050,'C-104');
insert into passengers values('P-109','Tayeem','Mosco',30,01610000002,'C-102');
insert into passengers values('P-110','Jon','Paris,Franch',49,02210000000,'C-100');
insert into passengers values('P-111','Sneha','London,UK',24,01610000000,'C-108');



insert into airfare values('A-b31',8000.00,'First','F1');
insert into airfare values('A-b41',7000.00,'First','F2');
insert into airfare values('A-b81',8000.00,'First','F6');
insert into airfare values('A-b91',7000.00,'First','F7');
insert into airfare values('A-b45',7000.00,'First','F9');
insert into airfare values('A-b56',9000.00,'First','F10');
insert into airfare values('A-b01',4000.00,'Bussiness','F1');
insert into airfare values('A-b02',4000.00,'Bussiness','F2');
insert into airfare values('A-b06',4000.00,'Bussiness','F6');
insert into airfare values('A-b07',3000.00,'Bussiness','F7');
insert into airfare values('A-b09',5000.00,'Bussiness','F9');
insert into airfare values('A-b10',4000.00,'Bussiness','F10');
insert into airfare values('A-e12',3000.00,'Economic','F1');
insert into airfare values('A-e13',2000.00,'Economic','F2');
insert into airfare values('A-e17',2000.00,'Economic','F6');
insert into airfare values('A-e18',3000.00,'Economic','F7');
insert into airfare values('A-e20',2000.00,'Economic','F9');
insert into airfare values('A-e21',3000.00,'Economic','F10');


insert into ticket values('T-1','S-1','A-b31','C-100','F1');
insert into ticket values('T-2','S-2','A-b41','C-101','F2');
insert into ticket values('T-3','S-3','A-b41','C-101','F2');
insert into ticket values('T-4','S-4','A-b07','C-102','F7');
insert into ticket values('T-5','S-5','A-e17','C-104','F6');
insert into ticket values('T-6','S-6','A-b06','C-106','F6');
insert into ticket values('T-7','S-7','A-b09','C-107','F9');
insert into ticket values('T-8','S-8','A-b09','C-107','F9');
insert into ticket values('T-9','S-9','A-b56','C-108','F10');
insert into ticket values('T-10','S-10','A-b07','C-109','F7');
insert into ticket values('T-11','S-11','A-b07','C-109','F7');
insert into ticket values('T-12','S-12','A-b07','C-109','F7');


insert into transaction values('T-01','F1','01-DEC-2014','C-100');
insert into transaction values('T-02','F2','01-NOV-2014','C-101');
insert into transaction values('T-03','F7','02-NOV-2014','C-102');
insert into transaction values('T-04','F6','15-FEB-2014','C-104');
insert into transaction values('T-05','F6','01-JAN-2015','C-106');
insert into transaction values('T-06','F6','01-DEC-2014','C-107');
insert into transaction values('T-07','F9','15-MAY-2015','C-108');
insert into transaction values('T-08','F9','15-MAY-2015','C-109');



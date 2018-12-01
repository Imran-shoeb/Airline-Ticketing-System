CREATE TABLE aircrafts (
ac_id varchar2(8) null,
model_no varchar2(15) null,
capacity varchar2(7) null,
mfd_by varchar2(10) null,
mfd_on varchar2(15) null,
PRIMARY KEY(ac_id)
);

CREATE TABLE flight(
flight_no varchar2(10) null,
leaving_from varchar2(12) null,
going_to varchar2(10) null,
dep_time varchar2(10) null,
dep_date varchar2(15) null,
arrival_time varchar2(12) null,
arrival_date varchar2(15) null,
ac_id varchar2(8) null,
PRIMARY KEY (flight_no),
FOREIGN KEY (ac_id) REFERENCES aircrafts (ac_id) ON DELETE CASCADE
);

CREATE TABLE customers(
cs_id varchar2(10) NULL,
cs_name varchar2(10) NULL,
cs_address varchar2(18) NULL,
cs_age varchar2(5) null,
cs_cellno varchar2(15) null,
PRIMARY KEY (cs_id)
); 

CREATE TABLE passengers(
ps_id varchar2(15) null,
ps_name varchar2(15) null,
ps_address varchar2(18) null,
ps_age varchar2(5) null,
ps_cellno varchar2(15) null,
cs_id varchar2(10) NULL,
PRIMARY KEY (ps_id),
FOREIGN KEY (cs_id) REFERENCES customers(cs_id) ON DELETE CASCADE
);

CREATE TABLE airfare(
af_id varchar2(8) null,
fare varchar2(8) null,
cls_type varchar2(10) null,
flight_no varchar2(10) null,
PRIMARY KEY (af_id),
FOREIGN KEY (flight_no) REFERENCES flight(flight_no) ON DELETE CASCADE
);

CREATE TABLE ticket(
t_id varchar2(10) null,
seat_no varchar2(8) null,
af_id varchar2(8) null,
cs_id varchar2(10) null,
flight_no varchar2(10) null,
PRIMARY KEY (t_id),
FOREIGN KEY (cs_id ) REFERENCES customers(cs_id ) ON DELETE CASCADE,
FOREIGN KEY (flight_no) REFERENCES flight(flight_no) ON DELETE CASCADE,
FOREIGN KEY (af_id) REFERENCES airfare(af_id) ON DELETE CASCADE 
);

CREATE TABLE transaction(
ts_id varchar2(8) null,
flight_no varchar2(10) null,
booking_date varchar2(15) null,
cs_id varchar2(10) NULL,
PRIMARY KEY (ts_id),
FOREIGN KEY (cs_id ) REFERENCES customers(cs_id ) ON DELETE CASCADE,
FOREIGN KEY (flight_no) REFERENCES flight(flight_no) ON DELETE CASCADE
);




create table desc_login(
user_type varchar2(10),
pass varchar2(10),
type_bit number
);

insert into desc_login values('admin','12345',1);
insert into desc_login values('employee1','54321',2);
insert into desc_login values('employee2','6789',2);
insert into desc_login values('employee3','asdfg',2);
insert into addresses values(1, "Naperville", "CHICAGO", "IL", "60515", "USA");
insert into addresses values(2, "Elgin", "CHICAGO", "IL", "60515", "USA");

insert into students values(1, "John", "john@gmail.com", "123-456-7890", null, null, null, 1);
insert into students values(2, "Paul", "paul@gmail.com", "111-222-3333", null, null, null, 2);

commit;

Select * from students left join addresses on students.addr_id = addresses.addr_id;
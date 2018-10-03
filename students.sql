insert into addresses values(1, "Naperville", "CHICAGO", "IL", "60515", "USA");
insert into addresses values(2, "Elgin", "CHICAGO", "IL", "60515", "USA");

insert into students values(1, "John", "john@gmail.com", "123-456-7890", null, null, null, 1);
insert into students values(2, "Paul", "paul@gmail.com", "111-222-3333", null, null, null, 2);
insert into students values(3, "Paul2", "paul2@gmail.com", "111-222-3333", null, null, null, 2);
select * from students;
delete from students where STUD_ID=3;
commit;

Select stud_id, name, email, phone, A.addr_id, street, city, state, zip, COUNTRY from students left join addresses A on students.addr_id = A.addr_id where STUD_ID=1;


insert into tutors values(1, "John", "john@gmail.com", "123-456-7890", 1);
insert into tutors values(2, "Ying", "ying@gmail.com", "111-222-3333", 2);

insert into courses values(1, "JavaSE", "Java SE", "2013-01-10", "2013-02-10", 1);
insert into courses values(2, "JavaEE", "JavaEE6", "2013-01-10", "2013-03-10", 2);
insert into courses values(3, "MyBatis", "MyBatis", "2013-01-10", "2013-02-20", 2);

select * from tutors;
select * from courses;

select T.tutor_id, T.name as Tutor_name, email, C.course_id, C.name, description, start_date, end_date
from tutors T left outer join courses C on T.TUTOR_ID = C.TUTOR_ID; 
commit;
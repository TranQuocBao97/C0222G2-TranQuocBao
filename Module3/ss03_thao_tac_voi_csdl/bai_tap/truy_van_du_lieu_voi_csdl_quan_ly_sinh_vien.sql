use quanlysinhvien;

select *
from student
where studentname like 'h%';

select *
from subject
where Credit between 3 and 5;

set sql_safe_updates = 0;
update student
set classid = 2
where studentname = 'hung';
set sql_safe_updates = 1;

create or replace view table_03 as
select student.studentname, `subject`.subname , mark.mark
from student inner join mark on student.StudentId = mark.StudentId
inner join `subject` on mark.SubId = `subject`.SubId
order by mark.mark desc;


-- sắp xếp tăng dần
create or replace view table_03_da_sap_xep_trung_diem as
select a.* 
from table_03 a, table_03 b
where a.studentname != b.studentname
and a.mark = b.mark
order by a.studentname desc;

select * from table_03_da_sap_xep_trung_diem
union
select * from table_03

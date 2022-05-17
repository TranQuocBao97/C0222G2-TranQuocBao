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


select student.studentname, `subject`.subname , mark.mark
from student inner join mark on student.StudentId = mark.StudentId
inner join `subject` on mark.SubId = `subject`.SubId
order by mark.mark desc;


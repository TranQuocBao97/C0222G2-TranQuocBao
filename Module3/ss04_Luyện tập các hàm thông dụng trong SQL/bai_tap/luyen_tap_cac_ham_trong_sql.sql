USE QuanLySinhVien;


select subject.*  
from subject
where subject.Credit in (select max(Credit) from subject);

select subject.*
from subject inner join
mark on subject.subid = mark.SubId
where mark.mark = (select max(mark) from mark);

select Student.*, avg(mark) as diem_trung_binh
from student inner join mark
on student.StudentId = mark.StudentId
group by student.StudentId
order by diem_trung_binh desc;
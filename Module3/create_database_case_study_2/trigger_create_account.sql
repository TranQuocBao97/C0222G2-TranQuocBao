SELECT * FROM control_furama.customer;
DELETE FROM `control_furama`.`customer` 
WHERE `customer_id`between 11 and 100;
select * from customer where customer_name like "%n%";

select * from employee;
select employee.* , employee_position.employee_position_name , education_degree.education_degree_name , division.division_name
from employee 
inner join employee_position on employee.employee_position_id = employee_position.employee_position_id
inner join education_degree on employee.education_degree_id = education_degree.education_degree_id
inner join division on employee.division_id = division.division_id;

select employee.* , employee_position.employee_position_name , education_degree.education_degree_name , division.division_name from employee 
inner join employee_position on employee.employee_position_id = employee_position.employee_position_id 
inner join education_degree on employee.education_degree_id = education_degree.education_degree_id 
inner join division on employee.division_id = division.division_id;

select * from employee
where instr(employee.employee_name,'2') or instr(employee.employee_id,'2');

select employee.* , employee_position.employee_position_name , education_degree.education_degree_name , division.division_name from employee 
inner join employee_position on employee.employee_position_id = employee_position.employee_position_id 
inner join education_degree on employee.education_degree_id = education_degree.education_degree_id 
inner join division on employee.division_id = division.division_id
where employee.employee_id like '%1%' and employee.employee_name like '%a%';




-- cách 1:

drop trigger create_accout_after_create_employee;

DELIMITER //
create trigger create_accout_after_create_employee before insert on employee
for each row
begin
	insert into `user` value (new.employee_email,'123abc');
	if new.username is null then
	set new.username = new.employee_email;
	end if;
end //
DELIMITER ;

-- -------------------------------------------------------------------
set sql_safe_updates = 0;
set sql_safe_updates = 1;
-- -------------------------------------------------------------------

-- vd tính ngày:
select DATEDIFF('2022-11-05','2020-35-05');

-- -------
DELIMITER //
create trigger update_total_money_after_create_contract before update on contract
for each row
begin
	create or replace view tong_tien_dat_phong as
	select contract.*,datediff(contract.contract_end_date,contract.contract_start_date)*service.service_cost as total_cost
	from contract left join service on contract.service_id = service.service_id;
end //
DELIMITER ;


select contract.contract_id,datediff(contract.contract_end_date,contract.contract_start_date)*service.service_cost as total_cost from contract left join service on contract.service_id = service.service_id;






DELIMITER //
create trigger update_total_money_after_create_contract before update on contract
for each row
begin
	set new.total = datediff(new.contract_start_date,new.contract_end_date);
end //
DELIMITER ;
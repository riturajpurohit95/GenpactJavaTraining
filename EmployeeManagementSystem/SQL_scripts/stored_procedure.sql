
-- create a stored procedure get_salary_by_id
-- two types of parameters - in, out
-- in - give that as an input - give id as input
-- out - which sp return as an output - salary as out
-- sp - inserting data - in

delimiter //

create procedure get_salary_by_id(
	in p_id int ,
	out p_salary decimal(12,2)
)
begin 
	
	select salary into p_salary  -- fetching salary and storing the result in out parameter
	from employee
	where id = p_id;    -- compare with in parameter - p_id
	
end //

delimiter ;
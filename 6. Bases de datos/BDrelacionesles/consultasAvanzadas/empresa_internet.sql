show databases;
use empresa_internet;
show tables;

select * from clients;
select * from plans;
select first_name from clients where plan_id = 3;
select first_name, last_name from clients where city = 'Buenos Aires';
select c.first_name, c.last_name, p.price from clients c join plans p on c.plan_id = p.plan_id where price > 1500;
select plan_id from plans where speed > 150;
select c.first_name, c.last_name, p.plan_id, p.price from clients c join plans p on c.plan_id = p.plan_id where speed > 100;
select c.first_name, c.last_name, p.plan_id, p.price from clients c join plans p on c.plan_id = p.plan_id order by price;
select c.first_name, c.last_name, p.plan_id, p.speed, p.price from clients c join plans p on c.plan_id = p.plan_id order by p.speed;
select * from clients where year(birthdate) between 1980 and 1990;
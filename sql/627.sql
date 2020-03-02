# https://leetcode.com/problems/swap-salary/

Create table if not exists salary(id int, name varchar(100), sex char(1), salary int);
Truncate Table salary;
Insert Into salary (id, name, sex, salary) Values ('1', 'A', 'm', '2500');
Insert Into salary (id, name, sex, salary) Values ('2', 'B', 'f', '1500');
Insert Into salary (id, name, sex, salary) Values ('3', 'C', 'm', '5500');
Insert Into salary (id, name, sex, salary) Values ('4', 'D', 'f', '500');

# Write your MySQL query statement below
Update salary
SET
    sex=Case
        WHEN sex='m' THEN 'f'
        WHEN sex='f' THEN 'm'
        ELSE sex
        END
;

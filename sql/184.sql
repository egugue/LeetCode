# https://leetcode.com/problems/department-highest-salary/

Drop Table Employee, Department;
Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department (Id int, Name varchar(255));
Truncate table Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '70000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Jim', '90000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('5', 'Max', '90000', '1');
Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');


# Write your MySQL query statement below
# Case of using Correlated Subquery
Select
    d1.Name AS Department,
    e1.Name AS Employee,
    e1.Salary AS Salary
From Employee e1
Inner Join Department d1 On e1.DepartmentId = d1.Id
Where e1.Salary = (
    Select
        MAX(e2.Salary)
    From Employee e2
    Inner Join Department d2 On e2.DepartmentId = d2.Id
    Where d1.Id = d2.Id
    Group By d2.Id
)
Order By Salary Desc
;

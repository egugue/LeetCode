# https://leetcode.com/problems/department-top-three-salaries/

Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department (Id int, Name varchar(255));
Truncate table Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '85000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Max', '90000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('5', 'Janet', '69000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('6', 'Randy', '85000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('7', 'Will', '70000', '1');
Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');


# Write your MySQL query statement below

# The below sql is original I submitted on 2020/3/5
# The sql can be more readable because Subquery can be defined in where clause
Select
    Department,
    Employee,
    Salary
From (
    Select
        d1.Name AS Department,
        e1.Name AS Employee,
        e1.Salary As Salary,
        ( Select COUNT(Distinct e2.Salary)
          From Employee e2
          Where e1.DepartmentId = e2.DepartmentId
                AND e1.Salary < e2.Salary
        ) + 1 AS _Rank
    From Department d1
    Inner Join Employee e1 On d1.Id = e1.DepartmentId
) AS Temp
Where _Rank <= 3
Order By Department, Salary Desc
;

# The below sql can reduce nested sql compared to the previous sql.
# But it takes more time (1530ms vs 785ms)
Select
    d1.Name AS Department,
    e1.Name AS Employee,
    e1.Salary As Salary
From Department d1
Inner Join Employee e1 On d1.Id = e1.DepartmentId
Where 3 >= (
      Select COUNT(Distinct e2.Salary)
      From Employee e2
      Where e1.DepartmentId = e2.DepartmentId
            AND e1.Salary < e2.Salary
    ) + 1
Order By Department, Salary Desc
;


## This could work on MySQL8 or higher
Select
    Department,
    Employee,
    Salary
From (
    Select
        d1.Name AS Department,
        e1.Name AS Employee,
        e1.Salary As Salary,
        DENSE_RANK() OVER (PARTITION By d1.Id Order By e1.Salary Desc) As _Rank
    From Department d1
    Inner Join Employee e1 On d1.Id = e1.DepartmentId
) AS Temp
Where
    _Rank <= 3
;

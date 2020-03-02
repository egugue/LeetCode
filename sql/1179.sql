# https://leetcode.com/problems/reformat-department-table/

Create table If Not Exists Department (id int, revenue int, month varchar(5));
Truncate table Department;
insert into Department (id, revenue, month) values ('1', '8000', 'Jan');
insert into Department (id, revenue, month) values ('2', '9000', 'Jan');
insert into Department (id, revenue, month) values ('3', '10000', 'Feb');
insert into Department (id, revenue, month) values ('1', '7000', 'Feb');
insert into Department (id, revenue, month) values ('1', '6000', 'Mar');

# Write your MySQL query statement below
Select
    id,
    SUM(Case When month='Jan' THEN revenue ELSE Null END) AS Jan_Revenue,
    SUM(Case When month='Feb' THEN revenue ELSE Null END) AS Feb_Revenue,
    SUM(Case When month='Mar' THEN revenue ELSE Null END) AS Mar_Revenue,
    SUM(Case When month='Apr' THEN revenue ELSE Null END) AS Apr_Revenue,
    SUM(Case When month='May' THEN revenue ELSE Null END) AS May_Revenue,
    SUM(Case When month='Jun' THEN revenue ELSE Null END) AS Jun_Revenue,
    SUM(Case When month='Jul' THEN revenue ELSE Null END) AS Jul_Revenue,
    SUM(Case When month='Aug' THEN revenue ELSE Null END) AS Aug_Revenue,
    SUM(Case When month='Sep' THEN revenue ELSE Null END) AS Sep_Revenue,
    SUM(Case When month='Oct' THEN revenue ELSE Null END) AS Oct_Revenue,
    SUM(Case When month='Nov' THEN revenue ELSE Null END) AS Nov_Revenue,
    SUM(Case When month='Dec' THEN revenue ELSE Null END) AS Dec_Revenue
From Department
Group By id
;

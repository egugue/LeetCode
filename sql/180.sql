# https://leetcode.com/problems/consecutive-numbers/

Create table If Not Exists Logs (Id int, Num int);
Truncate table Logs;
insert into Logs (Id, Num) values ('1', '1');
insert into Logs (Id, Num) values ('2', '1');
insert into Logs (Id, Num) values ('3', '1');
insert into Logs (Id, Num) values ('4', '2');
insert into Logs (Id, Num) values ('5', '1');
insert into Logs (Id, Num) values ('6', '2');
insert into Logs (Id, Num) values ('7', '2');

# Write your MySQL query statement below
# 739 ms	0B
Select Distinct
    l1.Num As ConsecutiveNums
From
    Logs l1, Logs l2, Logs l3
Where
    l1.Num = l2.Num
    And l2.Num = l3.Num
    And l1.Id = l2.Id + 1
    And l2.Id = l3.Id + 1
;
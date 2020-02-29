DROP TABLE Employee;

CREATE TABLE Employee (
    Id        INTEGER PRIMARY KEY,
    Name      Varchar(20) NOT NULL,
    Salary    INTEGER NOT NULL,
    ManagerId INTEGER
);

INSERT INTO Employee (Id, Name, Salary, ManagerId) VALUES
    (1, 'Joe',    70000, 3),
    (2, 'Henary', 80000, 4),
    (3, 'Sam',    60000, NULL),
    (4, 'Max',    90000, NULL)
;

# Write your MySQL query statement below
SELECT
    e1.Name as Employee
FROM
    Employee e1, Employee e2
Where
    e1.ManagerId = e2.Id
    AND e1.Salary > e2.Salary
;

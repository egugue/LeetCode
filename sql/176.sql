CREATE TABLE Employee (
  Id        INTEGER PRIMARY KEY,
  Salary    INTEGER NOT NULL
);

DELETE FROM Employee;

INSERT INTO Employee (Id, Salary) VALUES
    (1, 100),
    (2, 200),
    (3, 300)
;

# Write your MySQL query statement below
SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary < (
    SELECT MAX(Salary) FROM Employee
);
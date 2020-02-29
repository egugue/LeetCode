# https://leetcode.com/problems/customers-who-never-order/
DROP TABLE Customers, Orders;

CREATE TABLE Customers(
    Id   INTEGER     PRIMARY KEY,
    Name VARCHAR(20) NOT NULL
);

INSERT INTO Customers (Id, Name) VALUES
    (1, 'Joe'),
    (2, 'Henry'),
    (3, 'Sam'),
    (4, 'Max'),
    (5, 'Foo')
;

CREATE TABLE Orders(
    Id          INTEGER  PRIMARY KEY,
    CustomerId  INTEGER  NOT NULL,

    CONSTRAINT fk_customer_id
        FOREIGN KEY (CustomerId)
        REFERENCES Customers (Id)
        ON DELETE RESTRICT
        ON UPDATE RESTRICT
);

INSERT INTO Orders (Id, CustomerId) VALUES
    (1, 3),
    (2, 1),
    (3, 3),
    (4, 3)
;

SELECT * FROM Orders o
INNER JOIN Customers c ON o.CustomerId = c.Id
;

###############
# Write your MySQL query statement below
###############

# Case of Using Outer Join
SELECT
    c.Name AS Customers
FROM
    Customers c
LEFT JOIN Orders o ON c.id = o.CustomerId
WHERE
    o.Id IS NULL
;

# Case of using Exists
SELECT
    c.Name AS Customers
FROM
    Customers c
WHERE NOT EXISTS(
    SELECT
        *
    FROM
        Orders o
    WHERE
        c.id = o.CustomerId
)
;

# Case of using Not in which is official approach 1
SELECT
    c.Name AS Customers
FROM
    Customers c
WHERE
    c.Id NOT IN(
        SELECT o.CustomerId FROM Orders o
    )
;

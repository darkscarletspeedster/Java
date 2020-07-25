CREATE TABLE Employee (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    dept varchar(20),
    salary int(10)
);

INSERT INTO Employee values(600, 'Alexa', 'Legal', 5000);
    
SELECT * FROM Employee;

SELECT * FROM Employee WHERE salary = 5000;
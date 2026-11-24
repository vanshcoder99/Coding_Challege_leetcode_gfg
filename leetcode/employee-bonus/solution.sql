-- Write your PostgreSQL query statement below
SELECT name,bonus from Employee as e LEFT JOIN Bonus as b on e.empId=b.empId WHERE b.bonus<1000 OR b.bonus IS NULL;
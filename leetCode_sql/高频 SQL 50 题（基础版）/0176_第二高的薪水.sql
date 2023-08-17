SELECT IF(salary = (SELECT MAX(salary) FROM Employee), null, salary) SecondHighestSalary
FROM Employee
ORDER BY SecondHighestSalary DESC
LIMIT 1

SELECT name, bonus
FROM Employee
         LEFT JOIN Bonus
                   ON Employee.empId = Bonus.empId
WHERE bonus < 1000
   OR Bonus.bonus IS NULL
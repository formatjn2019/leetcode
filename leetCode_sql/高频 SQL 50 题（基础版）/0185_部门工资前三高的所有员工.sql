SELECT Department.name Department, e1.name Employee, e1.salary Salary
FROM Department
         RIGHT JOIN
     Employee e1
     ON Department.id = e1.departmentId
         LEFT JOIN Employee e2
                   ON e1.departmentId = e2.departmentId
                       AND e1.salary < e2.salary
GROUP BY e1.name
HAVING COUNT(DISTINCT e2.salary) < 3

SELECT Department.name Department, t.name Employee, salary Salary
FROM Department
         LEFT JOIN (SELECT departmentId, name, salary, RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) rk
                    FROM Employee) t
                   ON Department.id = t.departmentId
WHERE rk = 1
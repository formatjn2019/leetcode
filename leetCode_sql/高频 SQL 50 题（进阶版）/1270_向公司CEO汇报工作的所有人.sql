SELECT e3.employee_id
FROM Employees e1
         LEFT JOIN Employees e2
                   ON e1.manager_id = 1
                       AND e1.employee_id = e2.manager_id
         LEFT JOIN Employees e3
                   ON e2.employee_id = e3.manager_id
WHERE e3.employee_id IS NOT NULL
  AND e3.employee_id <> 1
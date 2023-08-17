SELECT e2.employee_id, e2.name, COUNT(*) reports_count, ROUND(AVG(e1.age)) average_age
FROM Employees e1
         inner join Employees e2
                    on e1.reports_to = e2.employee_id
GROUP BY e2.employee_id
ORDER BY e2.employee_id;

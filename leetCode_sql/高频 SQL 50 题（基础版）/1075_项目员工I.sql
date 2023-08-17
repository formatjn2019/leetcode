SELECT project_id, ROUND(SUM(experience_years) / COUNT(*), 2) average_years
FROM Project
         inner join Employee
                    on Project.employee_id = Employee.employee_id
GROUP BY project_id
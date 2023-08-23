SELECT Students.id, Students.name
FROM Departments
         RIGHT JOIN Students
                    ON Departments.id = Students.department_id
WHERE Departments.id IS NULL
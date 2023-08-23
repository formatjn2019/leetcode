SELECT project_id, employee_id
FROM (SELECT project_id, p.employee_id, RANK() OVER (PARTITION BY project_id ORDER BY experience_years DESC ) tk
      FROM Project p
               LEFT JOIN Employee e
                         ON p.employee_id = e.employee_id) t
WHERE tk = 1
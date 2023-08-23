SELECT employee_id, team_size
FROM Employee e
         LEFT JOIN (SELECT team_id, COUNT(*) team_size
                    FROM Employee
                    GROUP BY team_id) t
                   ON E.team_id = t.team_id
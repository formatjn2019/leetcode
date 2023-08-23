SELECT Country.name country
FROM Country
         LEFT JOIN
     Person
     ON SUBSTRING(phone_number, 1, 3) = country_code
         LEFT JOIN (SELECT caller_id id, duration
                    FROM Calls
                    UNION ALL
                    SELECT callee_id id, duration
                    FROM Calls) t
                   ON t.id = Person.id
GROUP BY country_code
HAVING AVG(duration) > (SELECT AVG(duration) FROM Calls)

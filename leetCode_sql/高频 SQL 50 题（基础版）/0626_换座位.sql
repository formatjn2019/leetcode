SELECT CASE
           WHEN s1.id % 2 = 1 AND s2.id is null
               THEN s1.id
           WHEN s1.id % 2 = 1
               THEN s1.id + 1
           ELSE s1.id - 1
           END id,
       s1.student
FROM Seat s1
         left join Seat s2
                   on s1.id = s2.id - 1
ORDER BY id

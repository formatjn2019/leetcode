SELECT MAX(t.num) num
FROM (SELECT num
      FROM MyNumbers
      GROUP BY num
      HAVING count(*) = 1) t
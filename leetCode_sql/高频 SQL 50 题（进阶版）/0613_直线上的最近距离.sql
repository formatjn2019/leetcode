SELECT IF((SELECT COUNT(x) <> COUNT(*)
           FROM Point), 0, MIN(p1.x - p2.x)) shortest
FROM Point p1
         LEFT JOIN Point p2
                   ON p1.x > p2.x
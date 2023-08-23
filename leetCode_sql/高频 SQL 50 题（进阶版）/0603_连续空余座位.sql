# 自连接
SELECT DISTINCT c1.seat_id
FROM Cinema c1
         INNER JOIN Cinema c2
                    ON c1.free = 1 AND c2.free = 1 AND (c2.seat_id = c1.seat_id + 1 or c2.seat_id = c1.seat_id - 1)
ORDER BY c1.seat_id;

# 窗口函数
SELECT seat_id
FROM (SELECT seat_id, free, LEAD(free, 1, 0) OVER () le, LAG(free, 1, 0) OVER () ov
      FROM Cinema) t
WHERE free = 1
  AND le + ov > 0
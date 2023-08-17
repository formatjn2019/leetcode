# 内连接
SELECT DISTINCT l1.num ConsecutiveNums
FROM Logs l1,
     Logs l2,
     Logs l3
WHERE l1.num = l2.num
  and l2.num = l3.num
  and l1.id = l2.id - 1
  and l2.id = l3.id - 1;


SELECT DISTINCT Num AS ConsecutiveNums
FROM Logs
WHERE (Id + 1, Num) IN (SELECT * FROM Logs)
  AND (Id + 2, Num) IN (SELECT * FROM Logs)
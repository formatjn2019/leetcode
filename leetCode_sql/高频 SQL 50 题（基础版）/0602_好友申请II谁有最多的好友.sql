SELECT id, SUM(NUM) NUM
FROM (SELECT requester_id id, COUNT(*) NUM
      FROM RequestAccepted
      GROUP BY id
      UNION
      SELECT accepter_id id, COUNT(*) NUM
      FROM RequestAccepted
      GROUP BY id) t
GROUP BY id
ORDER BY NUM DESC
LIMIT 1
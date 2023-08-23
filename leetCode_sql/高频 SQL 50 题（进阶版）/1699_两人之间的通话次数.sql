SELECT person1, person2, count(*) call_count, sum(duaration) total_duration
FROM (SELECT from_id person1, to_id person2, duaration
      FROM Calls c1
      WHERE from_id < to_id
      UNION ALL
      SELECT to_id person1, from_id person2, duaration
      FROM Calls c1
      WHERE from_id > to_id) t
GROUP BY person1, person2
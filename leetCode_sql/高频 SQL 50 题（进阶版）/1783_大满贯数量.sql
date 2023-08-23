SELECT player_id, player_name, COUNT(*) grand_slams_count
FROM (SELECT Wimbledon id
      FROM Championships
      UNION ALL
      SELECT Fr_open id
      FROM Championships
      UNION ALL
      SELECT US_open id
      FROM Championships
      UNION ALL
      SELECT Au_open id
      FROM Championships) t
         LEFT JOIN Players
                   ON id = player_id

GROUP BY player_id


# Write your MySQL query statement below
SELECT p.player_id,
       p.player_name,
       SUM(p.player_id = c.Wimbledon) + SUM(p.player_id = c.Fr_open) + SUM(p.player_id = c.US_open) +
       SUM(p.player_id = c.Au_open) grand_slams_count
FROM Championships c,
     Players p
GROUP BY p.player_id
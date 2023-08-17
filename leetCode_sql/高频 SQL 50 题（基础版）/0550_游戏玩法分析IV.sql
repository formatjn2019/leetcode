SELECT ROUND(count(player_id) / (SELECT count(distinct player_id) from Activity), 2) fraction
FROM Activity
WHERE (player_id, event_date) IN
      (SELECT player_id, ADDDATE(MIN(event_date), 1)
       FROM Activity
       GROUP BY player_id)
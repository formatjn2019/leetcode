SELECT Teams.team_id, team_name, IFNULL(SUM(score), 0) num_points
FROM Teams
         LEFT JOIN (SELECT host_team team_id,
                           CASE
                               WHEN host_goals > guest_goals
                                   THEN 3
                               WHEN host_goals = guest_goals
                                   THEN 1
                               ELSE
                                   0
                               END   score
                    FROM Matches
                    UNION ALL
                    SELECT guest_team team_id,
                           CASE
                               WHEN host_goals < guest_goals
                                   THEN 3
                               WHEN host_goals = guest_goals
                                   THEN 1
                               ELSE
                                   0
                               END    score
                    FROM Matches) t
                   ON Teams.team_id = t.team_id
GROUP BY Teams.team_id


ORDER BY num_points DESC, Teams.team_id
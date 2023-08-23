SELECT name, SUM(IFNULL(distance, 0)) travelled_distance
FROM Users
         LEFT JOIN Rides
                   ON Users.id = Rides.user_id
GROUP BY user_id
ORDER BY travelled_distance DESC, name
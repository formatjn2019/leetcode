SELECT Signups.user_id, round(sum(IF(action = 'confirmed', 1, 0)) / count(*), 2) confirmation_rate
FROM Signups
         left join Confirmations
                   on Signups.user_id = Confirmations.user_id
GROUP BY Signups.user_id
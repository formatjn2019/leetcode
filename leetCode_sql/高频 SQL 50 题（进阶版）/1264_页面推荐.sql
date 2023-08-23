SELECT DISTINCT page_id recommended_page
FROM Likes
         INNER JOIN (SELECT user2_id id
                     FROM Friendship
                     WHERE user1_id = 1
                     UNION
                     SELECT user1_id id
                     FROM Friendship
                     WHERE user2_id = 1) t
                    ON Likes.user_id = t.id
WHERE page_id NOT IN (SELECT page_id FROM Likes WHERE user_id = 1)

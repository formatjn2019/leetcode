(SELECT name results
 FROM MovieRating,
      Users
 WHERE MovieRating.user_id = Users.user_id
 GROUP BY MovieRating.user_id
 ORDER BY COUNT(*) DESC, name
 LIMIT 1)
UNION
(SELECT title results
 FROM MovieRating,
      Movies
 WHERE MovieRating.movie_id = Movies.movie_id
   AND YEAR(created_at) = 2020
   AND MONTH(created_at) = 2
 GROUP BY MovieRating.movie_id
 ORDER BY AVG(rating) DESC, title
 LIMIT 1)



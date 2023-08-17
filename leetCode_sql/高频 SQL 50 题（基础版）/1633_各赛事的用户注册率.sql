SELECT contest_id, ROUND(COUNT(*) / (SELECT COUNT(*) FROM Users) * 100, 2) percentage
FROM Users,
     Register
WHERE Register.user_id = Users.user_id
GROUP BY Register.contest_id
ORDER BY percentage DESC, contest_id;



SELECT contest_id, ROUND(COUNT(*) / (SELECT COUNT(*) FROM Users) * 100, 2) percentage
FROM Register
GROUP BY contest_id
ORDER BY percentage DESC, contest_id;
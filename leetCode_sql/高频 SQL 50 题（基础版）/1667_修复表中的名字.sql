SELECT user_id, CONCAT(UPPER(LEFT(name, 1)), LOWER(SubString(name, 2))) name
FROM Users
ORDER BY user_id
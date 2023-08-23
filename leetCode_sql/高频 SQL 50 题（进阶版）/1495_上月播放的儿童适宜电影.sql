SELECT DISTINCT c.title
FROM TVProgram AS tvp,
     Content as c
WHERE tvp.content_id = c.content_id
  AND Kids_content = 'Y'
  AND content_type = 'Movies'
  AND program_date between '2020-06-01' and '2020-06-30'
SELECT left_operand,
       operator,
       right_operand,
       CASE
           WHEN operator = '>'
               THEN IF(lv.value > rv.value, 'true', 'false')
           WHEN operator = '<'
               THEN IF(lv.value < rv.value, 'true', 'false')
           ELSE
               IF(lv.value = rv.value, 'true', 'false')
           END value
FROM Expressions e,
     Variables lv,
     Variables rv
WHERE e.left_operand = lv.name
  and e.right_operand = rv.name
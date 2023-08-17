SELECT tw.id id
FROM Weather tw
         LEFT JOIN Weather yw
                   ON DateDiff(tw.recordDate, yw.recordDate) = 1
WHERE tw.temperature > yw.temperature
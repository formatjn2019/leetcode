SELECT ROUND(SUM(tiv_2016), 2) tiv_2016
FROM (SELECT DISTINCT ii1.pid, ii1.tiv_2016
      FROM Insurance ii1,
           Insurance ii2
      WHERE ii1.tiv_2015 = ii2.tiv_2015
        AND ii1.pid <> ii2.pid
        AND ii1.pid not in (SELECT DISTINCT i1.pid
                            FROM Insurance i1,
                                 Insurance i2
                            WHERE i1.pid <> i2.pid

                              AND i1.lat = i2.lat
                              AND i1.lon = i2.lon)) t

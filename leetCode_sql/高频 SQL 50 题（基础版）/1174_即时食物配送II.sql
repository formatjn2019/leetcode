SELECT ROUND(SUM(DATEDIFF(d.order_date, d.customer_pref_delivery_date) = 0) / COUNT(*) * 100, 2) immediate_percentage
FROM (SELECT customer_id, MIN(order_date) order_date
      FROM Delivery
      GROUP BY customer_id) t
         LEFT JOIN
     Delivery d
     ON t.customer_id = d.customer_id AND
        t.order_date = d.order_date;

SELECT ROUND((AVG(DATEDIFF(order_date, customer_pref_delivery_date) = 0) * 100), 2) immediate_percentage
FROM Delivery
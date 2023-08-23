SELECT w.name warehouse_name, SUM(Width * Length * Height * units) volume
FROM Warehouse w
         INNER JOIN Products p
                    ON w.product_id = p.product_id
GROUP BY warehouse_name

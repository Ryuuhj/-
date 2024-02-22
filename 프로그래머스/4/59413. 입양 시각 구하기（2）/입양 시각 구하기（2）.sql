WITH RECURSIVE H 
    AS (SELECT 0 AS HOUR
        UNION ALL
        SELECT HOUR+1 FROM H
        WHERE HOUR < 23)
        
select  H.HOUR, IFNULL(T.COUNT, 0) AS COUNT
from H
LEFT JOIN (select DATE_FORMAT(DATETIME, '%H') HOUR, COUNT(*) as COUNT
            from ANIMAL_OUTS
            group by DATE_FORMAT(DATETIME, '%H')) T
USING (HOUR)
order by HOUR;

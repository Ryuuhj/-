# 7월까지의 (맛 별) 총 주문량 상위 3개 조회 (주문량 내림차순)
WITH T AS (SELECT*
           FROM FIRST_HALF
           UNION ALL 
           SELECT *
           FROM JULY)
SELECT FLAVOR
FROM T
GROUP BY FLAVOR
ORDER BY SUM(TOTAL_ORDER) DESC
LIMIT 3;
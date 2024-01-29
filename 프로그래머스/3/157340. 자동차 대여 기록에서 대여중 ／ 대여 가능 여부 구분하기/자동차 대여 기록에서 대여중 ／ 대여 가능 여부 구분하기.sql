/* 대여 시작일 <= 2022-10-16 <= 대여 종료일인 경우 대여 불가능
    -> CAR_ID 로 그룹핑 한 뒤, 대여 시작일 <= 2022-10-16 <= 대여 종료일인 경우만 '대여중'으로 출력
    -> 해당 테이블에 없는 데이터의 경우 '대여 가능'으로 출력
*/
WITH N AS (SELECT CAR_ID, '대여중' AS AB
          FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
          WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE
          GROUP BY CAR_ID)
SELECT DISTINCT Y.CAR_ID, IFNULL(N.AB, '대여 가능') AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY Y
LEFT JOIN N ON Y.CAR_ID = N.CAR_ID
ORDER BY Y.CAR_ID DESC;
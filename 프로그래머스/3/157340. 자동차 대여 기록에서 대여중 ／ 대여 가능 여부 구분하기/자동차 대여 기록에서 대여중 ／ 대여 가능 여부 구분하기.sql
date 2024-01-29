/* 대여 시작일 <= 2022-10-16 <= 대여 종료일인 경우 대여 불가능
    -> CAR_ID 로 그룹핑 한 뒤, 대여 시작일 <= 2022-10-16 <= 대여 종료일인 경우만 '대여중'으로 출력
    -> 해당 테이블에 없는 데이터의 경우 '대여 가능'으로 출력
*/
SELECT CAR_ID, IF(
    COUNT(IF('2022-10-16' BETWEEN START_DATE AND END_DATE, 1, NULL)) > 0, 
                  '대여중', '대여 가능') AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;
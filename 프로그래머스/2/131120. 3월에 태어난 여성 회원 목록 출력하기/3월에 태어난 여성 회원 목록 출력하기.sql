-- 회원ID, 이름, 성별, 생년월일 / 생일 3월/ 전화번호 IS NOT NULL / 회원 ID 기준 ASC
select MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
from MEMBER_PROFILE
where TLNO is not null and DATE_FORMAT(DATE_OF_BIRTH, '%m') = '03' and GENDER = 'W'
order by MEMBER_ID;
# 2022년도 평가점수 = 상반기 + 하반기 점수
with score_emp as (select emp_no, sum(score) score
                         from HR_GRADE
                         where year = 2022
                         group by emp_no),
max_score as (select max(score) ms from score_emp)
                
select S.SCORE, S.EMP_NO, H.EMP_NAME, H.POSITION, H.EMAIL
from score_emp S
join HR_EMPLOYEES H
using (emp_no)
where SCORE = (select max(score) ms from score_emp);

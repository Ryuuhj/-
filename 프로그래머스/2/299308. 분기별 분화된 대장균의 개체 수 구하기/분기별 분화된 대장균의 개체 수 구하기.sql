# 1 ~ 3 = 1, 4 ~ 6 = 2, 
select concat(QUARTER(DIFFERENTIATION_DATE), 'Q') as QUARTER , count(*) as ECOLI_COUNT
from ECOLI_DATA 
group by QUARTER
order by QUARTER



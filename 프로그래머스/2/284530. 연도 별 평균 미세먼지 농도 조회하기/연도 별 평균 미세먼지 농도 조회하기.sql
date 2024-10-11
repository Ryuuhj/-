select YEAR(YM) as year, round(avg(PM_VAL1), 2) as 'pm10', round(avg(PM_VAL2), 2) as 'PM2.5'
from AIR_POLLUTION 
where location2 = '수원'
group by YEAR(YM)
order by YEAR;
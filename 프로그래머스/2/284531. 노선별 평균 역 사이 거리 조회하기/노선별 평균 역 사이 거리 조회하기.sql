with t as (
    select ROUTE, ROUND(sum(D_BETWEEN_DIST), 1) td, ROUND(AVG(D_BETWEEN_DIST), 2) ad
    from subway_distance
    group by route)
    
select ROUTE, concat(td, "km") TOTAL_DISTANCE, concat(ad, "km") AVERAGE_DISTANCE
from t
order by td desc;
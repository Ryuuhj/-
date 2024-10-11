with cn as (
    select id, ntile(4) over (order by size_of_colony desc) as crank
    from ecoli_data
)

select id, 
    case
        when crank = 1 then 'CRITICAL'
        when crank = 2 then 'HIGH'
        when crank = 3 then 'MEDIUM'
        else 'LOW'
    end as 'COLONY_NAME'
from cn
order by id
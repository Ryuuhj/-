with recursive cte as (
    select id, parent_id, 1 as gen
    from ECOLI_DATA 
    where parent_id is null
    
    union all
    
    select e.id, e.parent_id, cte.gen + 1 as gen
    from ECOLI_DATA e
    join cte 
    on cte.id = e.parent_id
)

select count(*) as COUNT, a.gen as GENERATION
from cte a
left join cte b on a.id = b.parent_id
where b.id is null
group by a.gen
order by a.gen
select p.id, count(c.id) child_count
from ECOLI_DATA p
left join ECOLI_DATA c
on p.id = c.parent_id
group by p.id
order by p.id;
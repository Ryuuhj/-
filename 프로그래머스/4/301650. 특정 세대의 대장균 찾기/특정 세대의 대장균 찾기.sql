select a.id
from ECOLI_DATA a 
join ECOLI_DATA b
on a.parent_id = b.id
join ECOLI_DATA c
on b.parent_id = c.id
where c.parent_id is null
order by a.id
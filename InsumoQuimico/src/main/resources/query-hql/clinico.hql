select c.id,ch.id,enf.nombre,ope.nombre,inm.nombre,acc.nombre,ale.nombre,ch.lentes
from Clinico c
join c.persona per
join c.cliFichaHistorial ch
join ch.cfhOperaciones ope
join ch.cfhInmunizaciones inm
join ch.cfhEnfermedades enf
join ch.cfhAccidentes acc
join ch.cfhAlergias ale
where per.docIdentidad = '47180885'
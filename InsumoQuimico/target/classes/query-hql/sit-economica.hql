select ss.id,se.id,ocu.ocupacion,con.condicion,ded.dedicacion,tur.turno,se.centroTrabajo,
ing.padres,ing.abuelos,ing.trabajo,ing.otrosParientes,ing.pension,
egr.pensionUniversitaria,egr.alimentacion,egr.habitacion,egr.vestimenta,egr.movilidad,egr.utiles
from ServicioSocial ss
join ss.socSituacionEconomica se
join se.sseOcupacionLaboral ocu
join se.sseCondicion con
join se.sseDedicacion ded
join se.sseTurnoTrabajo tur
join se.sseIngreso ing
join se.sseEgreso egr
join ss.perfil p
join p.persona per
where per.docIdentidad = '47180885'

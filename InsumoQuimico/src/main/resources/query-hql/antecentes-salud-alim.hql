select ss.id, tip.tipo,tur.turno,esp.especialidad,ae.colegioTermino,ae.numPostulaciones,for.forma,senf.acudeEnfermedad,smot.motivo,ali.alimentacion
from ServicioSocial ss
join ss.socAlimentacion ali
join ss.socSalud sal
join sal.ssMotivo smot
join sal.ssAcudeEnfermedad senf
join ss.socAntEscolare ae
join ae.saeTipoColegio tip
join ae.saeTurno tur
join ae.saeEspecializacion esp
join ae.saeFormaIngreso for
join ss.perfil p
join p.persona per
where per.docIdentidad = '47180885'
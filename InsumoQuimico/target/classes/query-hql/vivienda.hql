

select ss.id,sv.id,t.tipo,ubi.ubicacion,mat.material,ten.tenencia,tip.tipo,agu.aguaPotable,
sh.servicioHigienico,ilu.iluminacion
from SocVivienda sv
join sv.servicioSocial ss
join sv.tipoVivienda t
join t.svUbicacion ubi
join t.svMatConstruccion mat
join t.svTenencia ten
join t.svTipo tip
join t.svAguaPotable agu
join t.svServiciosHigienico sh
join t.svIluminacion ilu
join ss.perfil p
join p.persona per
where per.docIdentidad = '47180885'
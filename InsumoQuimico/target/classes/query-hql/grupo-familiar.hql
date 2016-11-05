select g.docIdentidad,g.apellidoMaterno ||' '|| g.apellidoMaterno||', '  || g.nombres,g.parentesco,g.lugarNacimiento,
g.fechaNacimiento,g.estadoCivil,g.gradoInstruccion,g.ocupacion,g.ingresos
from GrupoFamiliar g
join g.persona per
where per.docIdentidad = '47180885'
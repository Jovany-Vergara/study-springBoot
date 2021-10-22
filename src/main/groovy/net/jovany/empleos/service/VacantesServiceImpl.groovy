package net.jovany.empleos.service

import net.jovany.empleos.model.Vacante
import org.springframework.stereotype.Service
import java.text.ParseException
import java.text.SimpleDateFormat

@Service
class VacantesServiceImpl  implements IVacantesService {

  List<Vacante> lista = null

  VacantesServiceImpl(){
    SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy")
    lista = new LinkedList<Vacante>()
    try {
      //Creamos la oferta 1
      Vacante vacante1 = new Vacante()
      vacante1.setId(1)
      vacante1.setNombre("Informatico")
      vacante1.setDescripcion("Se solicita empleado para hacer ejercicios de informatico")
      vacante1.setFecha(sdf.parse("08-03-2019"))
      vacante1.setSalario(8333.0)
      vacante1.setDestacado(1)
      vacante1.setImage("empresa1.jpeg")

      //Creamos la oferta 2
      Vacante vacante2 = new Vacante()
      vacante2.setId(2)
      vacante2.setNombre("Cientifico")
      vacante2.setDescripcion("Se solicita empleado, para la creacion de nuevas ciencias")
      vacante2.setFecha(sdf.parse("10-03-2020"))
      vacante2.setSalario(7000.0)
      vacante2.setDestacado(0)
      vacante2.setImage("empresa2.png")

      //Creamos la oferta 3
      Vacante vacante3 = new Vacante()
      vacante3.setId(3)
      vacante3.setNombre("Ing Civil")
      vacante3.setDescripcion("Se solicita empleado, para apoyar a las personas con información")
      vacante3.setFecha(sdf.parse("20-04-2015"))
      vacante3.setSalario(10000.0)
      vacante3.setDestacado(0)

      //Creamos la oferta 4
      Vacante vacante4 = new Vacante()
      vacante4.setId(4)
      vacante4.setNombre("Ing Sistemas")
      vacante4.setDescripcion("Se solicita empleado, para arreglar el sistema de una base de datos")
      vacante4.setFecha(sdf.parse("11-11-2011"))
      vacante4.setSalario(12000.0)
      vacante4.setDestacado(1)
      vacante4.setImage("empresa3.png")

      /**
       * Agregamos los 4 objetos de tipo vacante de la lista ...
       */
      lista.add(vacante1)
      lista.add(vacante2)
      lista.add(vacante3)
      lista.add(vacante4)
    }catch (ParseException e){
      println("Error: " + e.getMessage())
    }
  }

  @Override
  List<Vacante> buscarTodas() {
    return lista
  }

  @Override
  Vacante buscarPorId(Integer idVacante) {
    for (Vacante v : lista){
      if (v.getId()==idVacante) {
        return v
      }
    }
    return null
  }

  @Override
  void guardar(Vacante vacante) {
    lista.add(vacante)
  }
}

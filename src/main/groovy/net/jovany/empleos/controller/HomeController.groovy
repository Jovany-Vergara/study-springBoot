package net.jovany.empleos.controller

import net.jovany.empleos.model.Vacante
import net.jovany.empleos.service.IVacantesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

import java.sql.Date
import java.text.ParseException
import java.text.SimpleDateFormat

@Controller
class HomeController {

  @Autowired
  private IVacantesService serviceVacantes

  @GetMapping("/tabla")
  String mostrarTabla(Model model){
    List<Vacante> lista = serviceVacantes.buscarTodas()
    model.addAttribute("vacantes", lista)

    return "tabla"
  }

  @GetMapping("/detalle")
  String mostrarDetalle(Model model){
    Vacante vacante = new Vacante()
    vacante.setNombre("Developer")
    vacante.setDescripcion("Se solicita desarrollador para una pagina")
    /*vacante.setFecha(new Date())*/
    vacante.setSalario(9700.0)
    model.addAttribute("vacante", vacante)
    return "detalle";
  }

  @GetMapping("/listado")
  String mostrarListado(Model model){
    List<String> lista = new LinkedList<String>();
    lista.add("Developer");
    lista.add("Auxiliar de contabilidad")
    lista.add("vendedor")
    lista.add("Arquitecto")

    model.addAttribute("empleos", lista);

    return "listado";
  }

  @GetMapping("/")
  String motrarHome(Model model){
    List<Vacante> lista = serviceVacantes.buscarTodas()
    model.addAttribute("vacantes", lista)

    return "home";
  }

}

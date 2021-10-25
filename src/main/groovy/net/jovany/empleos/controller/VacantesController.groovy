package net.jovany.empleos.controller

import net.jovany.empleos.model.Vacante
import net.jovany.empleos.service.IVacantesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.propertyeditors.CustomDateEditor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes

import java.text.SimpleDateFormat

@Controller
@RequestMapping("/vacante")
class VacantesController {

  @Autowired
  private IVacantesService serviceVacantes

  @GetMapping("/index")
   String mostrarIndex(Model model) {
    List<Vacante> lista = serviceVacantes.buscarTodas();
    model.addAttribute("vacantes", lista);
    return "vacantes/listVacantes";
  }

  @GetMapping("/create")
  String crear( Vacante vacante){
    return "vacantes/formVacante"
  }
  /*
  @PostMapping("/save")
  String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion, @RequestParam("estatus") String estatus, @RequestParam("fecha") String fecha, @RequestParam("destacado") int destacado, @RequestParam("salario") double salario, @RequestParam("detalles") String detalles ){
    printf(" Nombre Vacante:, " + nombre)
    printf(" Descripcion:, " + descripcion)
    printf(" Estatus:, " + estatus)
    printf(" Fecha Publicacion:, " + fecha)
    printf(" Destacado:, " + destacado)
    printf(" Salario Ofrecido:, " + salario)
    printf(" Detalles:, " + detalles)
    return "vacantes/listVacantes"
  }
  */
  @PostMapping("/save")
  String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes){
    if (result.hasErrors()) {
      for (ObjectError error: result.getAllErrors()){
        println("Ocurrio un error: " + error.getDefaultMessage());
      }
      return "vacantes/formVacante";
    }
    serviceVacantes.guardar(vacante)
    attributes.addFlashAttribute("msg", "Registro Guardado")
    printf(" Vacante:, " + vacante)
    return "redirect:/vacante/index"
  }

  @GetMapping("/delete")
  String elemininar(@RequestParam("id") int idVacante, Model model){
    printf("borrando vacante con id" + idVacante)
    model.addAttribute("id", idVacante)
    return "mensaje"
  }

  @GetMapping("/view/{id}")
  String verDetalle(@PathVariable("id") int idVacante, Model model){
    Vacante vacante = serviceVacantes.buscarPorId(idVacante)
    printf("Vacante: " + vacante)
    model.addAttribute("vacante", vacante)

    //buscar los detalles en la vacante en la base de datos...
    return "detalle"
  }
  @InitBinder
   void initBinder(WebDataBinder webDataBinder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy")
    webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false))
  }
}

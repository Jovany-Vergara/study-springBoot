package net.jovany.empleos.controller

import net.jovany.empleos.model.Vacante
import net.jovany.empleos.service.IVacantesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/vacante")
class VacantesController {

  @Autowired
  private IVacantesService serviceVacantes

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
}

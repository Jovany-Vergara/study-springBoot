package net.jovany.empleos.service

import net.jovany.empleos.model.Vacante

interface IVacantesService {
  List<Vacante> buscarTodas()
  Vacante buscarPorId(Integer idVacante)
  void guardar(Vacante vacante)

}
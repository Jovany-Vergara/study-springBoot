package net.jovany.empleos.service

import net.jovany.empleos.model.Categoria

interface ICategoriasService {
  void guardar(Categoria categoria);
  List<Categoria> buscarTodas();
  Categoria buscarPorId(Integer idCategoria);
}
package net.jovany.empleos.model

class Categoria {
  private Integer id
  private String nombre
  private String descripcion

  Integer getId() {
    return id
  }

  void setId(Integer id) {
    this.id = id
  }

  String getNombre() {
    return nombre
  }

  void setNombre(String nombre) {
    this.nombre = nombre
  }

  String getDescripcion() {
    return descripcion
  }

  void setDescripcion(String descripcion) {
    this.descripcion = descripcion
  }

  @Override
  String toString() {
    return "Categoria{" +
        "id=" + id +
        ", nombre='" + nombre + '\'' +
        ", descripcion='" + descripcion + '\'' +
        '}';
  }
}

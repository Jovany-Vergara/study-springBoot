package net.jovany.empleos.model

class Vacante {

  private Integer id
  private String nombre
  private  String descripcion
  private Date fecha
  private Double salario
  private Integer destacado
  private String image="no-image.png"
  private String estatus
  private String detalles

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

  Date getFecha() {
    return fecha
  }

  void setFecha(Date fecha) {
    this.fecha = fecha
  }

  Double getSalario() {
    return salario
  }

  void setSalario(Double salario) {
    this.salario = salario
  }

  Integer getDestacado() {
    return destacado
  }

  void setDestacado(Integer destacado) {
    this.destacado = destacado
  }

  String getImage() {
    return image
  }

  void setImage(String image) {
    this.image = image
  }

  String getEstatus() {
    return estatus
  }

  void setEstatus(String estatus) {
    this.estatus = estatus
  }

  String getDetalles() {
    return detalles
  }

  void setDetalles(String detalles) {
    this.detalles = detalles
  }

  @Override
  public String toString() {
    return "Vacante{" +
        "id=" + id +
        ", nombre='" + nombre + '\'' +
        ", descripcion='" + descripcion + '\'' +
        ", fecha=" + fecha +
        ", salario=" + salario +
        ", destacado=" + destacado +
        ", image='" + image + '\'' +
        ", estatus='" + estatus + '\'' +
        ", detalles='" + detalles + '\'' +
        '}';
  }
}


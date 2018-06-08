package ar.com.unpaz.app.modelo;

public class Final {
	private int id;
	private String apel_nombre;
	private int id_alumno;
	private int id_materia;
	private String descripcion_materia;
	private float nota;
	private String deleteURL;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	public int getId_materia() {
		return id_materia;
	}
	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}
	public String getDescripcion_materia() {
		return descripcion_materia;
	}
	public void setDescripcion_materia(String descripcion_materia) {
		this.descripcion_materia = descripcion_materia;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public String getApel_nombre() {
		return apel_nombre;
	}
	public void setApel_nombre(String apel_nombre) {
		this.apel_nombre = apel_nombre;
	}
	public String getDeleteURL() {
		return deleteURL;
	}
	public void setDeleteURL(String deleteURL) {
		this.deleteURL = deleteURL;
	}
}

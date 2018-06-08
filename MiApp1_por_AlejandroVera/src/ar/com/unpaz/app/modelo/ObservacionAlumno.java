package ar.com.unpaz.app.modelo;

public class ObservacionAlumno {
	
	private int obs_id;
	private int avatar_id;
	private String descripcion;
	private int alu_id;
	private String objetivo;
	private String observaciones;
	
	
	public int getObs_id() {
		return obs_id;
	}
	public void setObs_id(int obs_id) {
		this.obs_id = obs_id;
	}
	public int getAvatar_id() {
		return avatar_id;
	}
	public void setAvatar_id(int avatar_id) {
		this.avatar_id = avatar_id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getAlu_id() {
		return alu_id;
	}
	public void setAlu_id(int alu_id) {
		this.alu_id = alu_id;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}

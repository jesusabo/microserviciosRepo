package com.vehiculo.service.pruebas.interfac;

public class FiguraDTO {

	private String nombreFigura;
	private int numeroLados;
	private int area;
	
	
	public FiguraDTO(int numeroLados, int area) {
		super();
		this.numeroLados = numeroLados;
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "FiguraDTO { tipo: "+nombreFigura+" con "+numeroLados+" y "+area+" m2 de area";
	}
	
	
	
}

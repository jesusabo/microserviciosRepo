package com.vehiculo.service.pruebas;

import com.vehiculo.service.pruebas.interfac.Figura;

public abstract class FabricaFiguras {
	
	
	public void getFigura(String figura) {
		
		Figura figuraNueva = crearFigura();
		
//		if(figura.equals("cuadrado")) {
//			return new Cuadrado();
//		}else {
//			return new Triangulo();
//		}
//		figuraNueva.dibujar(); 
	}

	
//	public void dibujarFigura() {
//		
//		Figura figura = crearFigura();
//		figura.dibujar();
//		
//	}
		public abstract Figura crearFigura();
	
}

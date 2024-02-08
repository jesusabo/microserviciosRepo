package com.vehiculo.service.pruebas;

import com.vehiculo.service.pruebas.interfac.Cuadrado;
import com.vehiculo.service.pruebas.interfac.Figura;

public class AplicacionFactory {

//	static FabricaFiguras fabricaFiguras;
	
	public static void main(String[] args) {
		
		Figura cuadrado = new CuadradoCreacion().crearFigura();
		Figura triangulo = new TrianguloCreacion().crearFigura();
		
		cuadrado.dibujar();
		triangulo.dibujar();
		
//		final String figura = "cuadrado";
//		fabricaFiguras = new CuadradoCreacion();
//		correrLogica();	
		
//		Figura claseCreadora = FabricaFiguras.getFigura("triangulo");
//		Figura claseCreadora1 = FabricaFiguras.getFigura("cuadrado");
//		
//		claseCreadora.dibujar();
//		claseCreadora1.dibujar();
		
//		Figura f1 = claseCreadora.getFigura("triangulo");
//		f1.dibujar();
//		
//		Figura f2 = claseCreadora.getFigura("cuadrado");
//		f2.dibujar();
	}
	
	
	
//	static void correrLogica() {
//		fabricaFiguras.crearFigura();
//	}

}

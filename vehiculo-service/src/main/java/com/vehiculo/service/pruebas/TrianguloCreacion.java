package com.vehiculo.service.pruebas;

import com.vehiculo.service.pruebas.interfac.Figura;
import com.vehiculo.service.pruebas.interfac.Triangulo;

public class TrianguloCreacion extends FabricaFiguras{

	@Override
	public Figura crearFigura() {
		return new Triangulo();
	}

	
}

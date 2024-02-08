package com.vehiculo.service.pruebas;

import com.vehiculo.service.pruebas.interfac.Cuadrado;
import com.vehiculo.service.pruebas.interfac.Figura;

public class CuadradoCreacion extends FabricaFiguras{

	@Override
	public Figura crearFigura() {
		return new Cuadrado();
	}



}

package com.vehiculo.service.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vehiculo.service.dto.CarroDTO;
import com.vehiculo.service.dto.FabricaCarroService;
import com.vehiculo.service.entity.Carro;
import com.vehiculo.service.servicio.CarroService;
import com.vehiculo.service.servicio.impl.CarroServiceImpl;
import com.vehiculo.service.util.Utilitario;

@RestController
@RequestMapping("/carroVehiculo")
public class CarroController {

	@Autowired
	private CarroService carroService;
	
	@Autowired
	private FabricaCarroService fabricaCarroService;
	
	@GetMapping()
	public List<Carro> listarCarros(){
		return carroService.findAll();
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<CarroDTO> guardar(@RequestBody @Validated CarroDTO carroDTO) {
		System.out.println("[[ carroVehiculo [ Guardar: "+carroDTO);
		String fecha = Utilitario.convertDateToString(carroDTO.getFechaCreacion(),"dd-MM-yyyy");
		System.out.println(fecha);
		String fechaReplace = fecha.replace('-', '/');
		System.out.println(fechaReplace);
		Date fechaParseada = Utilitario.convertStringToDate(fechaReplace, "dd/MM/yyyy");
		System.out.println(fechaParseada);
				
		carroDTO.setFechaCreacion(fechaParseada);
		
		CarroDTO carroGuardado = fabricaCarroService.converterCarroToCarroDTO(carroService.save(fabricaCarroService.converterCarroDTOtoCarro(carroDTO)));
		return new ResponseEntity<CarroDTO>(carroGuardado,HttpStatus.OK);
	}
	
	@PostMapping("/actualizar")
	public ResponseEntity<CarroDTO> actualizar(@RequestBody CarroDTO carroDTO){
		System.out.println();
		Carro carroActualizado = carroService.update(fabricaCarroService.converterCarroDTOtoCarro(carroDTO));
		return new ResponseEntity(carroActualizado,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/marca/{marca}")
	public ResponseEntity<List<Carro>> buscarPorMarca(@PathVariable String marca){
		System.out.println("[[ carroVehiculo [ buscar por marca: "+marca);
		return new ResponseEntity(fabricaCarroService.convertorListCarrosToCarrosDTO(carroService.findByMarca(marca)),HttpStatus.OK);
	}
	
	@GetMapping("/buscar/modelo/{modelo}")
	public ResponseEntity<List<CarroDTO>> buscarCarrosPorMarca(@PathVariable String modelo){
		System.out.println("[[ carroVehiculo [ buscar por modelo: "+modelo);
		return new ResponseEntity(fabricaCarroService.convertorListCarrosToCarrosDTO(carroService.findByModelo(modelo)),HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<CarroDTO> buscarCarrosPorMarca(@PathVariable int id){
		System.out.println("[[ carroVehiculo [ buscar por id: "+id);
		return new ResponseEntity(fabricaCarroService.converterCarroToCarroDTO(carroService.findById(id)),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminiarCarros(@PathVariable int id){
		System.out.println("[[ carroVehiculo [ eliminarCarros");
		carroService.delete(id);
		return new ResponseEntity<String>("Eliminado Correctamente",HttpStatus.OK);
	}
}

package model;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



public class Dispositivo {
	private int idDispositivo;
	private String nombre;
	private String codigo;
	private List<Metrica> lstMetricas;
	private Empresa empresa;
	
	public Dispositivo(String nombre, String codigo, Empresa empresa) throws Exception {
		super();
		this.setNombre(nombre);
		this.setCodigo(codigo);
		this.lstMetricas = new ArrayList<Metrica>();
		this.setEmpresa(empresa);
	}
	
	public Dispositivo(int idDispositivo, String nombre, String codigo, Empresa empresa) throws Exception {
		super();
		this.setIdDispositivo(idDispositivo);
		this.setNombre(nombre);
		this.setCodigo(codigo);
		this.lstMetricas = new ArrayList<Metrica>();
		this.setEmpresa(empresa);
	}
	
	
	public boolean agregarMetrica(int valor, LocalDate fecha, LocalTime hora) {
		return lstMetricas.add(new Metrica(valor, fecha, hora));
	}
	
	
	public Metrica traerMetrica(LocalDate fecha, LocalTime hora) {
		boolean metricaEncontrada=false;
		Metrica metricaBuscada=null;
		int i=0;
		
		while (i<lstMetricas.size() && !metricaEncontrada) {
			if(lstMetricas.get(i).getFecha().equals(fecha) && lstMetricas.get(i).getHora().equals(hora)) {
				metricaEncontrada=true;
				metricaBuscada=lstMetricas.get(i);
			}
			i++;
		}
		
		return metricaBuscada;
	}
	
	public List<Metrica> traerMetricas(LocalDate desde, LocalDate hasta) {
	
		List<Metrica> metricaBuscada=new ArrayList<Metrica>();
	
		for(int i=0;i<lstMetricas.size();i++) {
			if((lstMetricas.get(i).getFecha().isAfter(desde) || lstMetricas.get(i).getFecha().equals(desde)) && 
				(lstMetricas.get(i).getFecha().isBefore(hasta) || lstMetricas.get(i).getFecha().equals(hasta)) ) {
				metricaBuscada.add(lstMetricas.get(i));
			}
		}
		
		return metricaBuscada;
	}
	public List<Metrica> traerMetricass(Dispositivo dispositivo,LocalDate desde, LocalDate hasta,int menorAValor) {
		
		List<Metrica> metricaBuscada=new ArrayList<Metrica>();
	
		for(int i=0;i<lstMetricas.size();i++) {
			if(this.idDispositivo==dispositivo.getIdDispositivo()) {
				if(((lstMetricas.get(i).getFecha().isAfter(desde) || lstMetricas.get(i).getFecha().equals(desde)) && 
					(lstMetricas.get(i).getFecha().isBefore(hasta) || lstMetricas.get(i).getFecha().equals(hasta)))&&
						(lstMetricas.get(i).getValor()<menorAValor) ) {
					metricaBuscada.add(lstMetricas.get(i));
				}
			}
		}
		
		return metricaBuscada;
	}
	
	public boolean equals(String nombre) {
		return (this.nombre.equals(nombre));
	}

	@Override
	public String toString() {
		return "Dispositivo [idDispositivo=" + idDispositivo + ", nombre=" + nombre + ", codigo=" + codigo
				+ ", empresa=" + empresa +", lstMetricas=" + lstMetricas  + "]\n";
	}

	public int getIdDispositivo() {
		return idDispositivo;
	}
	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) throws Exception {
		if(codigo.length()!=5) {
			throw new Exception("Error: el codigo debe ser de 5 digitos");
		}
		
		if(validarCodigo(codigo)==false) {
			throw new Exception("Error: el codigo es invalido");
		}
		
		this.codigo=codigo;
	}
	
	private boolean validarCodigo(String codigo) {
		char[] array= codigo.toCharArray();
		int suma=0;
		char primerDigito=array[0];
		
		if( primerDigito=='A') {
			for(int i=1;i<array.length;i++) {
				suma=suma+Character.getNumericValue(array[i]);
			}
			
			if(suma%2==0) {
				return true;
			}
		}else if( primerDigito=='B') {
			for(int i=1;i<array.length;i++) {
				suma=suma+Character.getNumericValue(array[i]);
			}
			if(suma%2!=0) {
				return true;
			}
		}
		
		return false;
	}
	
	public List<Metrica> getLstMetricas() {
		return lstMetricas;
	}
	public void setLstMetricas(List<Metrica> lstMetricas) {
		this.lstMetricas = lstMetricas;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}

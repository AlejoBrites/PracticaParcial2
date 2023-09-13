package tests;

import java.time.LocalDate;
import java.time.LocalTime;

import model.SistemaSaludDispositivo;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SistemaSaludDispositivo s= new SistemaSaludDispositivo();
		System.out.println("Test 1");
		try {
			s.agregarEmpresa("Empresa 1");
			s.agregarEmpresa("Empresa 2");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(s.getLstEmpresas());
		
		System.out.println("Test 2");
		System.out.println(s.TraerEmpresa("Empresa 2"));
		
		System.out.println("Test 3");
		
		try {
			s.agregarDispositivo("Sensor Humedad", "A2020",s.TraerEmpresa("Empresa 1"));
			s.agregarDispositivo("Sensor Temperatura", "A2345",s.TraerEmpresa("Empresa 1"));
			s.agregarDispositivo("Sensor presion", "B2021",s.TraerEmpresa("Empresa 2"));
			s.agregarDispositivo("Sensor calor", "B2326",s.TraerEmpresa("Empresa 2"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.err.println(s.getLstDispositivos());
		System.out.println("Test 4");
		try {
			s.agregarDispositivo("Sensor movimiento","A2021",s.TraerEmpresa("Empresa 1"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Test 5");
		System.out.println(s.traerDispositivoN("Sensor calor"));
		
		System.out.println("Test 6");
		s.traerDispositivoN("Sensor calor").agregarMetrica(18,LocalDate.of(2022, 9, 18),LocalTime.of(10, 00));
		s.traerDispositivoN("Sensor calor").agregarMetrica(19,LocalDate.of(2022, 9, 19),LocalTime.of(12, 30));
		s.traerDispositivoN("Sensor calor").agregarMetrica(23,LocalDate.of(2022, 9, 20),LocalTime.of(15, 00));
		s.traerDispositivoN("Sensor calor").agregarMetrica(20,LocalDate.of(2022, 9, 21),LocalTime.of(18, 30));
		s.traerDispositivoN("Sensor calor").agregarMetrica(18,LocalDate.of(2022, 9, 22),LocalTime.of(22, 30));
		
		System.out.println(s.traerDispositivoN("Sensor calor").getLstMetricas());
		
		System.out.println("Test 7");
		System.out.println(s.traerDispositivoN("Sensor calor").traerMetrica(LocalDate.of(2022, 9, 19), LocalTime.of(12, 30)));
		System.out.println("Test 8");
		System.out.println(s.traerDispositivoN("Sensor calor").traerMetricas(LocalDate.of(2022, 9, 18), LocalDate.of(2022, 9, 21)));
		System.out.println("Test 9");
		System.out.println(s.traerDispositivoN("Sensor calor").traerMetricass(s.traerDispositivoN("Sensor calor"),LocalDate.of(2022, 9, 18), LocalDate.of(2022, 9, 21),22));
	}

}

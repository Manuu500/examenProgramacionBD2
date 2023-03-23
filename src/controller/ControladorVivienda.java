package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Localidad;
import model.Vivienda;

public class ControladorVivienda {

	/**
	 * 
	 * @return
	 */
	public static List<Vivienda> encuentraTodosID1() {
		List<Vivienda> lista = new ArrayList<Vivienda>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select v.descripcion from vivienda v, localidad l where v.idLocalidad = l.id and idLocalidad = 1;");
			
			while (rs.next()) {
				Vivienda l = new Vivienda();
				l.setDescripcion(rs.getString("descripcion"));
				lista.add(l);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return lista;
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Vivienda> encuentraTodosID2() {
		List<Vivienda> lista = new ArrayList<Vivienda>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select v.descripcion from vivienda v, localidad l where v.idLocalidad = l.id and idLocalidad = 2;");
			
			while (rs.next()) {
				Vivienda l = new Vivienda();
				l.setDescripcion(rs.getString("descripcion"));
				lista.add(l);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return lista;
	}
}

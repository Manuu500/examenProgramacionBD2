package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Localidad;

public class ControladorLocalidad {

	/**
	 * 
	 * @return
	 */
	public static List<Localidad> encuentraTodos() {
		List<Localidad> lista = new ArrayList<Localidad>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select descripcion from localidad");
			
			while (rs.next()) {
				Localidad l = new Localidad();
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

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Inquilino;

public class ControladorInquilino {

	/**
	 * 
	 * 
	 */
	public static Inquilino encuentraPrimerRegistro() {
		try {
			
		
			Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost/alquileres?serverTimezone=UTC","java", "Abcdefgh.1");
		   
			Statement s = (Statement) conexion.createStatement(); 
			
			ResultSet rs = s.executeQuery ("select * from vivienda v, inquilino i where v.id = i.idVivienda and i.idVivienda = 1");
		   
			Inquilino c = null;
			while (rs.next()) { 
				
				c = new Inquilino();
				c.setId(rs.getInt(1));
				c.setDni(rs.getString(5));
				c.setNombreCompleto(rs.getString(6));
				c.setFechaInicioAlquiler(rs.getString(7));
				c.setFechaFinAlquiler(rs.getString(8));
				c.setCuotaMensual(rs.getFloat(9));		
			}
			// Cierre de los elementos
			rs.close();
			s.close();
			conexion.close();
			return c;
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 
	 * @return
	 */
	
	public static Inquilino encuentraPrimerRegistro2() {
		try {
			
		
			Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost/alquileres?serverTimezone=UTC","java", "Abcdefgh.1");
		   
			Statement s = (Statement) conexion.createStatement(); 
			
			ResultSet rs = s.executeQuery ("select * from vivienda v, inquilino i where v.id = i.idVivienda and i.idVivienda = 2");
			Inquilino c = null;
			while (rs.next()) { 
				
				c = new Inquilino();
				c.setId(rs.getInt("id"));
				c.setDni(rs.getString(5));
				c.setNombreCompleto(rs.getString(6));
				c.setFechaInicioAlquiler(rs.getString(7));
				c.setFechaFinAlquiler(rs.getString(8));
				c.setCuotaMensual(rs.getFloat(9));		
			}
			// Cierre de los elementos
			rs.close();
			s.close();
			conexion.close();
			return c;
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static Inquilino encuentraPrimerRegistro3() {
		try {
			
		
			Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost/alquileres?serverTimezone=UTC","java", "Abcdefgh.1");
		   
			Statement s = (Statement) conexion.createStatement(); 
			
			ResultSet rs = s.executeQuery ("select * from vivienda v, inquilino i where v.id = i.idVivienda and i.idVivienda = 3");
			Inquilino c = null;
			while (rs.next()) { 
				
				c = new Inquilino();
				c.setId(rs.getInt("id"));
				c.setDni(rs.getString(5));
				c.setNombreCompleto(rs.getString(6));
				c.setFechaInicioAlquiler(rs.getString(7));
				c.setFechaFinAlquiler(rs.getString(8));
				c.setCuotaMensual(rs.getFloat(9));		
			}
			// Cierre de los elementos
			rs.close();
			s.close();
			conexion.close();
			return c;
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static Inquilino encuentraPrimerRegistro4() {
		try {
			
		
			Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost/alquileres?serverTimezone=UTC","java", "Abcdefgh.1");
		   
			Statement s = (Statement) conexion.createStatement(); 
			
			ResultSet rs = s.executeQuery ("select * from vivienda v, inquilino i where v.id = i.idVivienda and i.idVivienda = 4");
			Inquilino c = null;
			while (rs.next()) { 
				
				c = new Inquilino();
				c.setId(rs.getInt("id"));
				c.setDni(rs.getString(5));
				c.setNombreCompleto(rs.getString(6));
				c.setFechaInicioAlquiler(rs.getString(7));
				c.setFechaFinAlquiler(rs.getString(8));
				c.setCuotaMensual(rs.getFloat(9));		
			}
			// Cierre de los elementos
			rs.close();
			s.close();
			conexion.close();
			return c;
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public static int modificar(Inquilino c) throws SQLException {
		try {
		Connection conn = ConnectionManager.getConexion();
		PreparedStatement ps = conn.prepareStatement(
				"update inquilino set id = ?, dni = ?, nombreCompleto = ?, fechaInicioAlquiler = ?, fechaFinAlquiler = ?, cuotaMensual = ? where idVivienda = ?");
	
		ps.setInt(1, c.getId());
		ps.setString(2, c.getDni());
		ps.setString(3, c.getNombreCompleto());
		ps.setString(4, c.getFechaInicioAlquiler());
		ps.setString(5, c.getFechaFinAlquiler());
		ps.setFloat(6, c.getCuotaMensual());
		ps.setInt(7, c.getIdVivienda());
		
		
		return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}

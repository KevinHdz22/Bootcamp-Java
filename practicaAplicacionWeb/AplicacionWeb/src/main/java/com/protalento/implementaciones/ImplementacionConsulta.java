package com.protalento.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.protalento.entidades.Consulta;
import com.protalento.interfaces.ConexionMariaDB;
import com.protalento.interfaces.DAO;

public class ImplementacionConsulta implements DAO<Consulta>, ConexionMariaDB {
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementListar;
	
	@Override
	public boolean insertar(Consulta consulta) {
		// Evitar java.lang.NullPointerException
		if (consulta == null) {
			return false;
		}

		String sql = "insert into consultas (texto, url, fechaBusqueda) values (?,?,?)";
		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = getConexion().prepareStatement(sql);
			}

			preparedStatementInsertar.setString(1, consulta.getTexto());
			preparedStatementInsertar.setString(2, consulta.getUrl());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String fechaComoCadena = formatter.format(consulta.getFecha());
			preparedStatementInsertar.setString(3, fechaComoCadena);
			

			return preparedStatementInsertar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Consulta> listar() {
		List<Consulta> consultas = new ArrayList<Consulta>();
		String sql = "select texto, url, fechaBusqueda from consultas";
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = getConexion().prepareStatement(sql);
			}

			ResultSet resultSet = preparedStatementListar.executeQuery();
			
			while(resultSet.next()) {
				Consulta consulta = new Consulta();
				consulta.setTexto(resultSet.getString("texto"));
				consulta.setUrl(resultSet.getString("url"));
	
				LocalDate fecha1 = LocalDate.parse(resultSet.getString("fechaBusqueda"));
				consulta.setFecha(fecha1);
				
				consultas.add(consulta);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return consultas;
	}

}

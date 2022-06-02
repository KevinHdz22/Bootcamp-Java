package com.practicaBasesDeDatos.sistemaBancario.implementaciones.mariaDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.practicaBasesDeDatos.sistemaBancario.entidades.Jefe;
import com.practicaBasesDeDatos.sistemaBancario.interfaces.ConexionMariaDB;
import com.practicaBasesDeDatos.sistemaBancario.interfaces.DAO;

public class ImplementacionJefe implements DAO<Jefe, Integer>, ConexionMariaDB {

	private PreparedStatement preparedStatementBuscarPorID;
	private PreparedStatement preparedStatementEliminar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementListar;

	@Override
	public Jefe buscarPorId(Integer id) {
		Jefe jefe = null;
		String sql = "select nombreSubordinado from jefes where id = ?";
		try {
			if (preparedStatementBuscarPorID == null) {
				preparedStatementBuscarPorID = getConexion().prepareStatement(sql);
			}

			preparedStatementBuscarPorID.setInt(1, id);
			ResultSet resultSet = preparedStatementBuscarPorID.executeQuery();

			if (resultSet.next()) {
				jefe = new Jefe();
				jefe.setId(id);
				jefe.setNombreSubordinado(resultSet.getString("nombreSubordinado"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return jefe;
	}

	@Override
	public boolean insertar(Jefe jefe) {
		// Evitar java.lang.NullPointerException
		if (jefe == null) {
			return false;
		}

		String sql = "insert into jefes (id, nombreSubordinado) values (?,?)";
		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = getConexion().prepareStatement(sql);
			}

			preparedStatementInsertar.setInt(1, jefe.getId());
			preparedStatementInsertar.setString(2, jefe.getNombreSubordinado());

			return preparedStatementInsertar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Jefe jefe) {
		// Evitar java.lang.NullPointerException
		if (jefe == null) {
			return false;
		}

		String sql = "update jefes set nombreSubordinado = ? where id = ?";
		try {
			if (preparedStatementModificar == null) {
				preparedStatementModificar = getConexion().prepareStatement(sql);
			}
			preparedStatementModificar.setString(1, jefe.getNombreSubordinado());
			preparedStatementModificar.setInt(2, jefe.getId());

			return preparedStatementModificar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean eliminar(Jefe jefe) {
		// Evitar java.lang.NullPointerException
		if (jefe == null) {
			return false;
		}

		String sql = "delete from jefes where id = ?";
		try {
			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = getConexion().prepareStatement(sql);
			}
			preparedStatementEliminar.setInt(1, jefe.getId());

			return preparedStatementEliminar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Jefe> listar() {
		List<Jefe> jefes = new ArrayList<Jefe>();
		String sql = "select id, nombreSubordinado from jefes";
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = getConexion().prepareStatement(sql);
			}

			ResultSet resultSet = preparedStatementListar.executeQuery();
			
			while(resultSet.next()) {
				Jefe jefe = new Jefe();
				jefe.setId(resultSet.getInt("id"));
				jefe.setNombreSubordinado(resultSet.getString("nombreSubordinado"));
				jefes.add(jefe);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jefes;
	}

}

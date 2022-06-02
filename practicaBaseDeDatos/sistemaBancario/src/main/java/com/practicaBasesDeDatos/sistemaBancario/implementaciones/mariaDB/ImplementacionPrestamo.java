package com.practicaBasesDeDatos.sistemaBancario.implementaciones.mariaDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.practicaBasesDeDatos.sistemaBancario.entidades.Prestamo;
import com.practicaBasesDeDatos.sistemaBancario.interfaces.ConexionMariaDB;
import com.practicaBasesDeDatos.sistemaBancario.interfaces.DAO;

public class ImplementacionPrestamo implements DAO<Prestamo, Integer>, ConexionMariaDB {

	private PreparedStatement preparedStatementBuscarPorID;
	private PreparedStatement preparedStatementEliminar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementListar;

	@Override
	public Prestamo buscarPorId(Integer id) {
		Prestamo prestamo = null;
		String sql = "select fechaSolicitud, id_Cliente from prestamos where id = ?";
		try {
			if (preparedStatementBuscarPorID == null) {
				preparedStatementBuscarPorID = getConexion().prepareStatement(sql);
			}

			preparedStatementBuscarPorID.setInt(1, id);
			ResultSet resultSet = preparedStatementBuscarPorID.executeQuery();

			if (resultSet.next()) {
				prestamo = new Prestamo();
				prestamo.setId(id);
				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("fechaSolicitud"));
				prestamo.setFechaSolicitud(date1);
				prestamo.setIdCliente(resultSet.getInt("id_cliente"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return prestamo;
	}

	@Override
	public boolean insertar(Prestamo prestamo) {
		// Evitar java.lang.NullPointerException
		if (prestamo == null) {
			return false;
		}

		String sql = "insert into prestamos (id, fechaSolicitud, id_cliente) values (?,?,?)";
		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = getConexion().prepareStatement(sql);
			}

			preparedStatementInsertar.setInt(1, prestamo.getId());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String fechaComoCadena = sdf.format(prestamo.getFechaSolicitud());
			preparedStatementInsertar.setString(2, fechaComoCadena);
			preparedStatementInsertar.setInt(3, prestamo.getIdCliente());

			return preparedStatementInsertar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Prestamo prestamo) {
		// Evitar java.lang.NullPointerException
		if (prestamo == null) {
			return false;
		}

		String sql = "update prestamos set fechaSolicitud = ?, id_cliente = ? where id = ?";
		try {
			if (preparedStatementModificar == null) {
				preparedStatementModificar = getConexion().prepareStatement(sql);
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String fechaComoCadena = sdf.format(prestamo.getFechaSolicitud());
			preparedStatementModificar.setString(1, fechaComoCadena);
			preparedStatementModificar.setInt(2, prestamo.getIdCliente());
			preparedStatementModificar.setInt(3, prestamo.getId());

			return preparedStatementModificar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean eliminar(Prestamo prestamo) {
		// Evitar java.lang.NullPointerException
		if (prestamo == null) {
			return false;
		}

		String sql = "delete from prestamos where id = ?";
		try {
			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = getConexion().prepareStatement(sql);
			}
			preparedStatementEliminar.setInt(1, prestamo.getId());

			return preparedStatementEliminar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Prestamo> listar() {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		String sql = "select id, fechaSolicitud, id_cliente from prestamos";
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = getConexion().prepareStatement(sql);
			}

			ResultSet resultSet = preparedStatementListar.executeQuery();
			
			while(resultSet.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setId(resultSet.getInt("id"));
				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("fechaSolicitud"));
				prestamo.setFechaSolicitud(date1);
				prestamo.setIdCliente(resultSet.getInt("id_cliente"));
				prestamos.add(prestamo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return prestamos;
	}

}

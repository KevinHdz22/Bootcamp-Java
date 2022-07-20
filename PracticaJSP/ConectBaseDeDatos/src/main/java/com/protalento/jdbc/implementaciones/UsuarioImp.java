package com.protalento.jdbc.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.protalento.entidades.Usuario;
//import com.protalento.excepciones.PatronExcepcion;
import com.protalento.jdbc.AdministradorDeConexionMariaDB;
import com.protalento.jdbc.interfaces.IUsuario;


public class UsuarioImp implements IUsuario {
	private PreparedStatement preparedStatementBuscarPorId;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementEliminar;
	private PreparedStatement preparedStatementListar;
	private AdministradorDeConexionMariaDB administradorDeConexionMariaDB;

	public UsuarioImp() {
		administradorDeConexionMariaDB = new AdministradorDeConexionMariaDB();
	}

	@Override
	public Usuario buscarPorID(String correo) {
		Usuario usuario = null;
		String sql = "select AES_DECRYPT(clave,?) as clave from Usuarios where correo = ?";
		try {
			if (null == preparedStatementBuscarPorId) {
				preparedStatementBuscarPorId = administradorDeConexionMariaDB.getConexion().prepareStatement(sql);
			}

			preparedStatementBuscarPorId.setString(1, administradorDeConexionMariaDB.getLlave());
			preparedStatementBuscarPorId.setString(2, correo);

			ResultSet resultSet = preparedStatementBuscarPorId.executeQuery();

			if (resultSet.next()) {
				usuario = new Usuario();
				usuario.setCorreo(correo);
				usuario.setClave(resultSet.getString("clave"));
			}

			// logger.debug(preparedStatementBuscarPorId);

			// logger.info(usuario);

		} catch (SQLException e) {
			// logger.error(e);
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public boolean insertar(Usuario usuario) {
		String sql = "insert into Usuarios (correo, clave) values (?,AES_ENCRYPT(?,?))";
		try {

			if (null == preparedStatementInsertar) {
				preparedStatementInsertar = administradorDeConexionMariaDB.getConexion().prepareStatement(sql);
			}

			preparedStatementInsertar.setString(1, usuario.getCorreo());
			preparedStatementInsertar.setString(2, usuario.getClave());
			preparedStatementInsertar.setString(3, administradorDeConexionMariaDB.getLlave());
			
			//logger.debug(preparedStatementInsertar);
			//logger.info(usuario);
			
			return preparedStatementInsertar.executeUpdate() == 1;
		} catch (SQLException e) {
			//logger.error(e);
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modificar(Usuario usuario) {
		String sql = "update usuarios set clave = AES_ENCRYPT(?,?) where correo = ?";
		try {
			if (null == preparedStatementModificar) {
				preparedStatementModificar = administradorDeConexionMariaDB.getConexion().prepareStatement(sql);
			}

			preparedStatementModificar.setString(1, usuario.getClave());
			preparedStatementModificar.setString(2, administradorDeConexionMariaDB.getLlave());
			preparedStatementModificar.setString(3, usuario.getCorreo());
			
			//logger.debug(preparedStatementModificar);
			//logger.info(usuario);

			return preparedStatementModificar.executeUpdate() == 1;

		} catch (SQLException e) {
			//logger.error(e);
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean eliminar(Usuario usuario) {
		String sql = "delete from usuarios where correo = ?";
		try {
			if (null == preparedStatementEliminar) {
				preparedStatementEliminar = administradorDeConexionMariaDB.getConexion().prepareStatement(sql);
			}
			preparedStatementEliminar.setString(1, usuario.getCorreo());
			
			//logger.debug(preparedStatementEliminar);
			//logger.info(usuario);

			return preparedStatementEliminar.executeUpdate() == 1;
		} catch (SQLException e) {
			//logger.error(e);
		}
		return false;
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select correo, AES_DECRYPT(clave,?) as clave from Usuarios";
		try {
			if (null == preparedStatementListar) {
				preparedStatementListar = administradorDeConexionMariaDB.getConexion().prepareStatement(sql);
			}

			preparedStatementListar.setString(1, administradorDeConexionMariaDB.getLlave());

			ResultSet resultSet = preparedStatementListar.executeQuery();

			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setCorreo(resultSet.getString("correo"));
				usuario.setClave(resultSet.getString("clave"));
	
				// agregamos a la lista
				usuarios.add(usuario);
			}
			
			//logger.debug(preparedStatementListar);
			//logger.info(usuarios);
		} catch (SQLException  e) {
			//logger.error(e);
		}
		return usuarios;
	}

	@Override
	public Usuario buscarPorCorreoClave(String correo, String clave) {
		Usuario usuario = buscarPorID(correo);
		if (null != usuario && usuario.getClave().equals(clave)) {
			return usuario;
		}else {
			return null;
		}	
	}

	public static void main(String[] args) {
		Usuario usuario = new Usuario("calebQT@gmail.com", "HolaMundo20");
		
		System.out.println(usuario);

		UsuarioImp iUsuario = new UsuarioImp();
		iUsuario.insertar(usuario);
		//iUsuario.buscarPorID("calebhdz@gmail.com");// true
		//iUsuario.buscarPorID("user1@educacoionit.com");// false
		//System.out.println("hola" + iUsuario.buscarPorCorreoClave("calebhdzQ@gmail.com", "protalento2021S"));
		//iUsuario.modificar(usuario);
		//iUsuario.eliminar(usuario);
		System.out.println(iUsuario.listar());

	}

}

package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assembler.Assembler;

public abstract class CrudRepository<T> {

	private static final String CONNECTION_URL = "jdbc:sqlserver://DESKTOP-4C6GE5G\\SQLEXPRESS:1433;databaseName=Syn;integratedSecurity=true";
	private Assembler<T> assembler;

	public CrudRepository(Assembler<T> assembler) {
		this.assembler = assembler;
	}

	protected void execute(String sql, String... parameters) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			for (int i = 0; i < parameters.length; i++) {
				statement.setString(i + 1, parameters[i]);
			}
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeConnection(connection);
		}
	}

	protected List<T> find(String sql, String... parameters) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result;
			List<T> resultList = new ArrayList<>();
			for (int i = 0; i < parameters.length; i++) {
				statement.setString(i + 1, parameters[i]);
			}
			result = statement.executeQuery();
			while (result.next()) {
				resultList.add(assembler.convert(result));
			}
			return resultList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeConnection(connection);
		}
	}

	private Connection getConnection() {
		try {
			return DriverManager.getConnection(CONNECTION_URL);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
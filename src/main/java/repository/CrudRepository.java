package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class CrudRepository {

	private String connectionUrl = "jdbc:sqlserver://DESKTOP-4C6GE5G\\SQLEXPRESS:1433;databaseName=Syn;integratedSecurity=true";

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
	
	protected ResultSet find(String sql) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeConnection(connection);
		}
	}

	protected ResultSet find(String sql, String... parameters) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result;
			for (int i = 0; i < parameters.length; i++) {
				statement.setString(i + 1, parameters[i]);
			}
			result = statement.executeQuery();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeConnection(connection); // this can't close connection because result deletes
		}
	}

	private Connection getConnection() {
		try {
			return DriverManager.getConnection(connectionUrl);
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

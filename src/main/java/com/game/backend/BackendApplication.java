package com.game.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		Properties props = new Properties();

		try (InputStream input = BackendApplication.class.getClassLoader().getResourceAsStream("application.properties")) {
			if (input == null) {
				System.err.println("Unable to find application.properties");
				return;
			}
			props.load(input);
		} catch (Exception e) {
			System.err.println("Failed to load application.properties");
			e.printStackTrace();
			return;
		}

		String jdbcUrl = props.getProperty("spring.datasource.url");
		String username = props.getProperty("spring.datasource.username");
		String password = props.getProperty("spring.datasource.password");

		try {
			// Explicitly load the MySQL JDBC driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Successfully connected to the database!");
			connection.close();
		} catch (SQLException e) {
			System.err.println("Failed to connect to the database.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("MySQL JDBC Driver not found. Include it in your library path!");
			e.printStackTrace();
		}
	}
}

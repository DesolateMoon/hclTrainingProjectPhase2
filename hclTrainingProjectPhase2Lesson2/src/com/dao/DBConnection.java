package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String sql = "insert into product(name, department, cost) values(?,?,?)";
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

			Statement statement = conn.createStatement();

			statement.executeUpdate(
					"create table product (id integer auto_increment primary key, name varchar(255), department varchar(255), cost decimal(10,2))");

			System.out.println("Creating database products.");

			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, "Laptop");
			pst.setString(2, "Electronics");
			pst.setDouble(3, 1500);
			pst.executeUpdate();

			pst.setString(1, "Phone");
			pst.setString(2, "Electronics");
			pst.setDouble(3, 1000);
			pst.executeUpdate();

			pst.setString(1, "IEMs");
			pst.setString(2, "Electronics");
			pst.setDouble(3, 260);
			pst.executeUpdate();

			pst.setString(1, "Microwave");
			pst.setString(2, "Appliances");
			pst.setDouble(3, 420);
			pst.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection is closed.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
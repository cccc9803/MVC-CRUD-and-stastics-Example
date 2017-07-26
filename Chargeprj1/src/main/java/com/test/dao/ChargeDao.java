package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.model.Charge;
import com.test.util.DbUtil;

public class ChargeDao {
	private Connection connection;

	public ChargeDao() {
		connection = DbUtil.getConnection();
	}

	public void insertCharge(Charge charge) {
		try {
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into chargedb (Date,Subject,Cost,Reason)" + "VALUES(? , ? , ? , ?)");

			preparedStatement.setString(1, charge.getDate());
			preparedStatement.setString(2, charge.getSubject());
			preparedStatement.setString(3, charge.getCost());
			preparedStatement.setString(4, charge.getReason());
			if (charge != null) {
				preparedStatement.executeUpdate();
			}
			connection.setAutoCommit(true);
			preparedStatement.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					System.err.print("Transaction is being rolled back");
					connection.rollback();
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}

	}

	public void deletCharge(int idCharge) {
		try {
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM chargedb WHERE idCharge=?");
			
			preparedStatement.setInt(1, idCharge);
			preparedStatement.executeUpdate();
			connection.setAutoCommit(true);
			preparedStatement.close();
			

		} catch (Exception e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					System.err.print("Transaction is being rolled back");
					connection.rollback();
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());

				}
			}
		}

	}

	public void updateChargeById(Charge charge) {
		try {
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE chargedb SET Date=?, Subject=?, Cost=?, Reason=? WHERE idCharge =?");						
			preparedStatement.setString(1, charge.getDate());
			preparedStatement.setString(2, charge.getSubject());
			preparedStatement.setString(3, charge.getCost());
			preparedStatement.setString(4, charge.getReason());
			preparedStatement.setInt(5, charge.getIdCharge());
			preparedStatement.executeUpdate();
			System.out.println(preparedStatement);
			connection.setAutoCommit(true);
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					System.err.print("Transaction is being rolled back");
					connection.rollback();
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());

				}
			}

		}
	}

	public List<Charge> getChargeById(int idCharge) {
		List<Charge> charges = new ArrayList<Charge>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT idCharge, Date , Subject , Cost, Reason, Note FROM chargedb WHERE idCharge =?");
			preparedStatement.setInt(1, idCharge);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

		   while(rs.next()) {
			    Charge charge = new Charge();
				charge.setIdCharge(rs.getInt("idCharge"));
				charge.setDate(rs.getString("date"));
				charge.setSubject(rs.getString("subject"));
				charge.setCost(rs.getString("cost"));
				charge.setReason(rs.getString("reason"));
				charge.setNote(rs.getString("note"));
				charges.add(charge);
			}
		   System.out.println(charges.size());
			rs.close();
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return charges;
	}

	public List<Charge> getChargeByReason(String reason) {
		List<Charge> charges = new ArrayList<Charge>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT idCharge, Date, Subject, Cost, Reason, Note From chargedb WHERE reason=?");
			preparedStatement.setString(1, reason);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Charge charge = new Charge();
				charge.setIdCharge(rs.getInt("idCharge"));
				charge.setDate(rs.getString("date"));
				charge.setSubject(rs.getString("subject"));
				charge.setCost(rs.getString("cost"));
				charge.setReason(rs.getString("reason"));
				charge.setNote(rs.getString("note"));
				charges.add(charge);
			}
			rs.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return charges;
	}

	public List<Charge> getChargeByDate(String dateStart, String dateEnd) {
		List<Charge> charges = new ArrayList<Charge>();
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(
					"" + "SELECT idCharge, Date, Subject, Cost, Reason, Note FROM chargedb WHERE Date >=" + "'"
							+ dateStart + "'" + "AND Date <=" + "'" + dateEnd + "'");

			ResultSet rs = preparedstatement.executeQuery();

			while (rs.next()) {
				Charge charge = new Charge();
				charge.setIdCharge(rs.getInt("idCharge"));
				charge.setDate(rs.getString("Date"));
				charge.setSubject(rs.getString("Subject"));
				charge.setCost(rs.getString("Cost"));
				charge.setReason(rs.getString("Reason"));
				charge.setNote(rs.getString("Note"));
				charges.add(charge);
			}
			rs.close();
			preparedstatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return charges;

	}

	public List<Charge> getChargeBySubject(String subSelect) {
		List<Charge> charges = new ArrayList<Charge>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"" + "SELECT idCharge, Date, Subject, Cost, Reason, Note FROM chargedb WHERE subject =?");
			preparedStatement.setString(1, subSelect);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Charge charge = new Charge();
				charge.setIdCharge(rs.getInt("idCharge"));
				charge.setDate(rs.getString("Date"));
				charge.setSubject(rs.getString("Subject"));
				charge.setCost(rs.getString("Cost"));
				charge.setReason(rs.getString("Reason"));
				charge.setNote(rs.getString("Note"));
				charges.add(charge);
			}

			rs.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(charges.size());
		return charges;

	}

	
		
	
	
}

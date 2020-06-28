package bank.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bank.db.Customer;
import bank.db.Provider;

public class CustomerDao 
{
	public static double getAmount(Customer c) 
	{
		double db_amount = 0;
		try 
		{
			Connection con = Provider.getOracleConnection();
			String sql = "Select amount from bank where accno=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setLong(1, c.getAccno());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) 
			{
				db_amount = rs.getLong(1);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return db_amount;
	}

	public static int updateAmount(Customer c) 
	{
		int status = 0;
		try 
		{
			Connection con = Provider.getOracleConnection();
			String sql = "Update bank set amount=? where accno=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, c.getAmount());
			pst.setLong(2, c.getAccno());
			status = pst.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}

}

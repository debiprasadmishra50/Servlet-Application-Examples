package login.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import login.db.Users;

public class UsersDao 
{
	public static int doRegister(Users u) 
	{
		int status = 0;
		try 
		{
			Connection con = login.db.Provider.getOracleConnection();
			String sql = "Insert into Users values (?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, u.getUsername());
			pst.setString(2 , u.getPassword());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getPhone());
			pst.setString(5, u.getRegdno());
			pst.setString(6, u.getCollege());
			
			status = pst.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}

	public static boolean doValidate(Users u) 
	{
		boolean result = false;
		String email = null;
		String password = null;
		try 
		{
			Connection con = login.db.Provider.getOracleConnection();
			String sql = "Select * from Users where email=? and password=? ";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2 , u.getPassword());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) 
			{
				result = true;
			}
			else
				result = false;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return result;
	}

	public static String getPassword(Users u) 
	{
		String password = null;
		try 
		{
			Connection con = login.db.Provider.getOracleConnection();
			String sql = "Select password from Users where email=? ";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) 
			{
				password = rs.getString(1);
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return password;
	}
	
}

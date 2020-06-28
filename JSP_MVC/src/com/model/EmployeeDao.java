package com.model;

import java.sql.*;

import com.db.Employee;
import com.db.Provider;

public class EmployeeDao 
{
	public static int addNewEmployee(Employee e)
	{
		int status = 0;
		try 
		{
			Connection con = Provider.getOracleConnection();
			String sql = "insert into Employee values (?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, e.getEid());
			pst.setString(2, e.getEname());
			pst.setDouble(3, e.getSalary());
			pst.setString(4, e.getEmail());
			pst.setString(5, e.getPassword());
			pst.setLong(6, e.getPhone());
			
			status = pst.executeUpdate();
		} 
		catch (Exception e2) 
		{
			e2.printStackTrace();
		}
		return status;
	}
}

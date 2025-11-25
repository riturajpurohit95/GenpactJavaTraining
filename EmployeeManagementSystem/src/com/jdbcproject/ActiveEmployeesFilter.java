package com.jdbcproject;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.Predicate;

//predicate - interface where we define logic
//creating the filter

public class ActiveEmployeesFilter implements Predicate{

	//predicate interface
	//-should implement predicate interface
	//-defines logic to text each row
	
	@Override
	public boolean evaluate(RowSet rs) {
		
		try {
			return rs.getBoolean("is_active");
		}catch(SQLException e)
		{
			return false;
		}
	}
	
	@Override
	public boolean evaluate(Object value, int column) throws SQLException{
		
		return false;
	}
	
	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException{
		
		return false;
	}
	
}

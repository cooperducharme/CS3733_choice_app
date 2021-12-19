package main.java.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Choice;

/**
 * Note that CAPITALIZATION matters regarding the table name. If you create with 
 * a capital "Constants" then it must be "Constants" in the SQL queries.
 * 
 * @author heineman
 *
 */
public class ChoiceDAO { 

	java.sql.Connection conn;
	
	final String tblName = "Constants";   // Exact capitalization

    public ChoiceDAO() {
    	try  {
    		conn = DatabaseUtil.connect();
    	} catch (Exception e) {
    		conn = null;
    	}
    }

    public Choice getConstant(String name) throws Exception {
        
        try {
        	Choice constant = null;
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE name=?;");
            ps.setString(1,  name);
            ResultSet resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                constant = generateConstant(resultSet);
            }
            resultSet.close();
            ps.close();
            
            return constant;

        } catch (Exception e) {
        	e.printStackTrace();
            throw new Exception("Failed in getting constant: " + e.getMessage());
        }
    }
    
    public boolean updateConstant(Choice constant) throws Exception {
        try {
        	String query = "UPDATE " + tblName + " SET value=? WHERE name=?;";
        	PreparedStatement ps = conn.prepareStatement(query);
            //ps.setDouble(1, constant.value);
            //ps.setString(2, constant.name);
            int numAffected = ps.executeUpdate();
            ps.close();
            
            return (numAffected == 1);
        } catch (Exception e) {
            throw new Exception("Failed to update report: " + e.getMessage());
        }
    }
    
    public boolean deleteConstant(Choice constant) throws Exception {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM " + tblName + " WHERE name = ?;");
            //ps.setString(1, constant.name);
            int numAffected = ps.executeUpdate();
            ps.close();
            
            return (numAffected == 1);

        } catch (Exception e) {
            throw new Exception("Failed to insert constant: " + e.getMessage());
        }
    }


    public boolean addConstant(Choice constant) throws Exception {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tblName + " WHERE name = ?;");
            //ps.setString(1, constant.name);
            ResultSet resultSet = ps.executeQuery();
            
            // already present?
            while (resultSet.next()) {
            	Choice c = generateConstant(resultSet);
                resultSet.close();
                return false;
            }

            ps = conn.prepareStatement("INSERT INTO " + tblName + " (name,value) values(?,?);");
            //ps.setString(1,  constant.name);
            //ps.setDouble(2,  constant.value);
            ps.execute();
            return true;

        } catch (Exception e) {
            throw new Exception("Failed to insert constant: " + e.getMessage());
        }
    }

    public List<Choice> getAllConstants() throws Exception {
        
        List<Choice> allConstants = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM " + tblName + ";";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
            	Choice c = generateConstant(resultSet);
                allConstants.add(c);
            }
            resultSet.close();
            statement.close();
            return allConstants;

        } catch (Exception e) {
            throw new Exception("Failed in getting constants: " + e.getMessage());
        }
    }
    
    private Choice generateConstant(ResultSet resultSet) throws Exception {
        String name  = resultSet.getString("name");
        Double value = resultSet.getDouble("value");
        return new Choice ();
    }

}
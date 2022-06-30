package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnector {

	JsonConfigReader jsonConfigReader = new JsonConfigReader();
	public String db_url = jsonConfigReader.getConfigValue("DBcredentials", "db_url");
	public String db_username = jsonConfigReader.getConfigValue("DBcredentials", "db_username");
	public String db_password = jsonConfigReader.getConfigValue("DBcredentials", "db_password");
	
	public  void deleteDBrecords() throws SQLException, ClassNotFoundException {	

		
	String deleteUsers = "delete from con_users where user_name like 'Auto%'";
	String deleteCompanies = "delete from con_companies where company_name like 'Auto%'";
	String deleteRoles = "delete from con_roles where role_name like 'Auto%'";
	String deleteResponsibilities = "delete from con_responsibilities where resp_name like 'Auto%'";
	String deleteDevices = "delete from con_devices where device_name like 'Auto%'";
	String deleteNamespaces = "delete from con_field_namespaces where namespace_name like 'Auto%'";
	String deleteFields = "delete from con_fields where field_name like 'Auto%'";
	String deleteFlexfields = "delete from con_flexfields where flexfield_name like 'Auto%'";
	String deleteFolders = "delete from con_folders where folder_name like 'Auto%'";
	String deleteMenus = "delete from con_menus where menu_name like 'Auto%'";

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection(db_url,db_username,db_password);
	Statement stmt = con.createStatement();
	
	stmt.executeQuery(deleteUsers);
	stmt.executeQuery(deleteCompanies);
	stmt.executeQuery(deleteRoles);
	stmt.executeQuery(deleteResponsibilities);
	stmt.executeQuery(deleteDevices);
	stmt.executeQuery(deleteNamespaces);
	stmt.executeQuery(deleteFields);
	stmt.executeQuery(deleteFlexfields);
	stmt.executeQuery(deleteFolders);
	stmt.executeQuery(deleteMenus);
	
		con.close();
	
	}
}

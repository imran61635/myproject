package utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import common.Setup_Page;

public class DButilities  {
	
    public static Properties DB = new Properties();
	public static FileInputStream fis;
	public static Connection con;
	public static Statement stmt;
	public static ResultSet rs;
	public static ArrayList<String> list;
	public  static void connect() {
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/DB.properties");
			
		} catch (FileNotFoundException ex) {
			
			ex.printStackTrace();}
		try {
			DB.load(fis);
		} catch (IOException exx) {
			
			exx.printStackTrace();
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Retrieving the data frpm property file                              
			String URL=DB.getProperty("DBURL");
			String id=DB.getProperty("id");
			String pwd=DB.getProperty("pwd");
			con = DriverManager.getConnection(URL,id,pwd);
			stmt = con.createStatement();
			System.out.println("DB connected succefully");
		} catch (Exception e) {
			System.out.println("DB not connected due to wrong credentilas/DB down");
			e.printStackTrace();
		} 
		 
		
	
	}
	//This method returns only WRID if query fired only for single WRID values
	 public static String getWRID(String sql ) {
		
		   connect();
		   String woid=null;
		   
			 try {
				rs = stmt.executeQuery(sql);
				while(rs.next()) { 
				woid= rs.getString(1); 
					
			} 
				return woid; 
			 }catch (SQLException e) {
				
				e.printStackTrace();
				return null;
				
			}
			 finally {
					
				 try {
					con.close();
					System.out.println("DB connection closed");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			 }
			
		 }
	 //This method return only count of row
	 public static String getCount(String sql ) {
			
		   connect();
		   String woid=null;
		   
			 try {
				rs = stmt.executeQuery(sql);
				while(rs.next()) { 
				woid= rs.getString(1); 
					
			} 
				return woid; 
			 }catch (SQLException e) {
				
				e.printStackTrace();
				return null;
				
			}
			 finally {
					
				 try {
					con.close();
					System.out.println("DB connection closed");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			 }
			
		 }
	 //This method return any single column which is fired in query
	 public static String getSingleColumn(String sql ) {
			
		   connect();
		   String woid=null;
		   
			 try {
				rs = stmt.executeQuery(sql);
				while(rs.next()) { 
				woid= rs.getString(1); 
					
			} 
				return woid; 
			 }catch (SQLException e) {
				
				e.printStackTrace();
				return null;
				
			}
			 finally {
					
				 try {
					con.close();
					System.out.println("DB connection closed");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			 }
			
		 }
	 //this the most generic and optimised query handling method, it caters all column for a single row, returns column name and values
	 public static   LinkedHashMap<String, String> getAllColumns(String sql) {
		 connect();
		
		 LinkedHashMap<String, String> colNameWithValues=new  LinkedHashMap<String, String>();
		 String colName=null;
		 String colValues=null;
		
		 try {
				rs = stmt.executeQuery(sql);
				while(rs.next()) { 
				ResultSetMetaData rsmd = rs.getMetaData();
				int colCount=rsmd.getColumnCount();
				for(int i=1;i<=colCount;i++) {
					
					colName=rsmd.getColumnName(i);
					colValues= rs.getString(i);
					colNameWithValues.put(colName, colValues);
				
				}
				
					
			} 
				System.out.println("Printing all column name with values");
				System.out.println("#############################################");
				for(Map.Entry M : colNameWithValues.entrySet()) {
					 System.out.println(M.getKey()+":"+M.getValue());
				}
				return colNameWithValues;
			 }catch (SQLException e) {
				
				e.printStackTrace();
				return colNameWithValues;
		          }
		 finally {
				
			 try {
				con.close();
				System.out.println("DB connection closed");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		 }
	
	 }
	 
	 //this method is just for testing purpose not related with framework
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		 String woid="M9057000030";
		String SQLquery1="select WRID,SOURCETYPE,EXTKEY1,WRSTAT FROM xbfwr_t where EXTKEY2='"+woid+"'";
		HashMap<String, String> colNameWithValues= getAllColumns(SQLquery1);
		//String WRID=getWRID("select * from work_order where ROWNUM<=1");
		//HashMap<String, String> colNameWithValues=getAllColumns("select work_order_id,job_category, order_subtype,clli, destination_system, status,\r\n" + 
		 	//	"job_type,zip, dwelling_type,product_group_list, source_type, trouble_description,\r\n" + 
		 	//	"transport_type, billing_name,LOCAL_ACCESS_START_DTTM,LOCAL_ACCESS_END_DTTM from edge.work_order where work_order_id = 'M9056000063'");
		//getWRID();
		//while(rs.next()) { 
			//String woid = rs.getString(1); 
			//System.out.println(WRID); 
	//	 for(int i=0; i<list.size();i++)
			 
		//	System.out.println("value is: "+list.get(i)); 
		// for(Map.Entry M : colNameWithValues.entrySet()) {
		//	 System.out.println(M.getKey()+":"+M.getValue());}
		//System.out.println("CILLI: "+colNameWithValues.get("CLLI"));
		
		//System.out.println(colNameWithValues);
			//con.close();
			//System.out.println(DB.getProperty("DBURL"));
			//String taskKey = rs.getString("task_key"); 
			//System.out.println(taskKey);

	

	}
}
package com.GenericOptimisationDataModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.stringutil.DBUtil;

public class InsertOptimisedParametersData {

	public static void cityCTRoptimisation(String campaignId,String channel,String marketValue) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;
		Statement stmt = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());  
//		List<ParameterCTRDTO> cityctr = new ArrayList<ParameterCTRDTO>();
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,CTR) VALUES("+"'"+date+"'"+","+"'"+campaignId+"'"+","+"'"+channel+"'"+",'CITY',"+"'"+marketValue+"'"+",1)";
        System.out.println(query);
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
	  
	}



	public static void OSCTRoptimisation(String campaignId, String channel,String marketValue ) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;
	//	List<ParameterCTRDTO> osctr = new ArrayList<ParameterCTRDTO>();
		Statement stmt = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime()); 
		
		
		
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,CTR) VALUES("+"'"+date+"'"+","+"'"+campaignId+"'"+","+"'"+channel+"'"+",'OS',"+"'"+marketValue+"'"+",1)";
		System.out.println(query);
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 finally{
	        	
	        	
				DBUtil.close(stmt);
				DBUtil.close(con);
				
			} 
	
	}



	public static void SegmentCTRoptimisation(String campaignId,String channel, String marketValue) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;         //		List<SegmentCTRDTO> segmentctr = new ArrayList();
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt = null;
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime()); 
		
		
		
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,CTR) VALUES("+"'"+date+"'"+","+"'"+campaignId+"'"+","+"'"+channel+"'"+",'Audience_Segment',"+'"'+marketValue+'"'+",1)";
		System.out.println(query);
		System.out.println(query);
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	     

	}

	
	
	public static void AgeCTRoptimisation(String campaignId,String channel, String marketValue) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;         //		List<SegmentCTRDTO> segmentctr = new ArrayList();
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt = null;
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime()); 
		
		
		
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,CTR) VALUES("+"'"+date+"'"+","+"'"+campaignId+"'"+","+"'"+channel+"'"+",'Age',"+'"'+marketValue+'"'+",1)";
		System.out.println(query);
		System.out.println(query);
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
		    stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 finally{
	        	
	        	
				DBUtil.close(stmt);
				DBUtil.close(con);
				
			} 

	}

	
	public static void GenderCTRoptimisation(String campaignId,String channel, String marketValue) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;         //		List<SegmentCTRDTO> segmentctr = new ArrayList();
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime()); 
		Statement stmt = null;
		
		
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,CTR) VALUES("+"'"+date+"'"+","+"'"+campaignId+"'"+","+"'"+channel+"'"+",'Gender',"+'"'+marketValue+'"'+",1)";
		System.out.println(query);
		System.out.println(query);
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 

	}

	
	
	
	
	

	public static void cityCPCoptimisation(String campaignId, String channel, String marketValue) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;

		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt = null;
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());
		
		
		//		List<ParameterCPCDTO> citycpc = new ArrayList<ParameterCPCDTO>();
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,CPC) VALUES("+"'"+date+"'"+","+"'"+campaignId+"'"+","+"'"+channel+"'"+",'CITY',"+"'"+marketValue+"'"+",1)";
		System.out.println(query);
		
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
	    
	}



	public static void OSCPCoptimisation(String campaignId, String channel,  String marketValue) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt = null;
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());
		
		
		//	List<OSCPCDTO> oscpc = new ArrayList<OSCPCDTO>();
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,CPC) VALUES("+"'"+date+"'"+","+"'"+campaignId+"'"+","+"'"+channel+"'"+",'OS',"+"'"+marketValue+"'"+",1)";
		System.out.println(query);
		
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
		    stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	   
	}



	public static void SegmentCPCoptimisation(String campaignId,String channel, String marketValue) {


		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt = null;
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());
		
		
		//	List<SegmentCPCDTO> segmentcpc = new ArrayList<SegmentCPCDTO>();
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,CPC) VALUES("+"'"+date+"'"+","+"'"+campaignId+"'"+","+"'"+channel+"'"+",'Audience_Segment',"+'"'+marketValue+'"'+",1)";
		System.out.println(query);
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
		
	}
     
	
	public static void AgeCPCoptimisation(String campaignId,String channel, String marketValue) {


		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt = null;
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());
		
		
		//	List<SegmentCPCDTO> segmentcpc = new ArrayList<SegmentCPCDTO>();
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,CPC) VALUES("+"'"+date+"'"+","+"'"+campaignId+"'"+","+"'"+channel+"'"+",'Age',"+'"'+marketValue+'"'+",1)";
		System.out.println(query);
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
	
		
	}
	
	
	public static void GenderCPCoptimisation(String campaignId,String channel, String marketValue) {


		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt = null;
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());
		
		
		//	List<SegmentCPCDTO> segmentcpc = new ArrayList<SegmentCPCDTO>();
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,CPC) VALUES("+"'"+date+"'"+","+"'"+campaignId+"'"+","+"'"+channel+"'"+",'Gender',"+'"'+marketValue+'"'+",1)";
		System.out.println(query);
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
       finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
		
	}
	
     
     
     

	public static void cityConvCostoptimisation(String campaignId, String channel, String marketValue) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt = null;
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());
		
		
		//		List<ParameterCPCDTO> citycpc = new ArrayList<ParameterCPCDTO>();
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,ConvCost) VALUES("+date+","+campaignId+","+channel+",CITY,"+marketValue+",1)";

		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
		    stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
	    
	}



	public static void OSConvCostoptimisation(String campaignId, String channel,  String marketValue) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt = null;
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());
		
		
		//	List<OSCPCDTO> oscpc = new ArrayList<OSCPCDTO>();
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,ConvCost) VALUES("+date+","+campaignId+","+channel+",OS,"+marketValue+",1)";
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 

	   
	}



	public static void SegmentConvCostoptimisation(String campaignId,String channel, String marketValue) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt = null;
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());
		
		
		//	List<SegmentCPCDTO> segmentcpc = new ArrayList<SegmentCPCDTO>();
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,ConvCost) VALUES("+date+","+campaignId+","+channel+",Audience_Segment,"+marketValue+",1)";
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
		
	}
     
	
	public static void AgeConvCostoptimisation(String campaignId,String channel, String marketValue) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());
		Statement stmt = null;
		
		//	List<SegmentCPCDTO> segmentcpc = new ArrayList<SegmentCPCDTO>();
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,ConvCost) VALUES("+date+","+campaignId+","+channel+",Age,"+marketValue+",1)";
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
		
	}
	
	
	public static void GenderConvCostoptimisation(String campaignId,String channel, String marketValue) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt = null;
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());
		
		
		//	List<SegmentCPCDTO> segmentcpc = new ArrayList<SegmentCPCDTO>();
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,ConvCost) VALUES("+date+","+campaignId+","+channel+",Gender,"+marketValue+",1)";
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
		
	}
	


	public static void cityConvRateoptimisation(String campaignId, String channel, String marketValue) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt = null;
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());
		
		
		//		List<ParameterCPCDTO> citycpc = new ArrayList<ParameterCPCDTO>();
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,ConvRate) VALUES("+"'"+date+"'"+","+"'"+campaignId+"'"+","+"'"+channel+"'"+",'CITY',"+"'"+marketValue+"'"+",1)";
        System.out.println(query);
		
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
	    
	}



	public static void OSConvRateoptimisation(String campaignId, String channel,  String marketValue) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt = null;
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());
		
		
		//	List<OSCPCDTO> oscpc = new ArrayList<OSCPCDTO>();
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,ConvRate) VALUES("+"'"+date+"'"+","+"'"+campaignId+"'"+","+"'"+channel+"'"+",'OS',"+"'"+marketValue+"'"+",1)";
		System.out.println(query);
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
		

	   
	}



	public static void SegmentConvRateoptimisation(String campaignId,String channel, String marketValue) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt = null;
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());
		
		
		//	List<SegmentCPCDTO> segmentcpc = new ArrayList<SegmentCPCDTO>();
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,ConvRate) VALUES("+"'"+date+"'"+","+"'"+campaignId+"'"+","+"'"+channel+"'"+",'Audience_Segment',"+'"'+marketValue+'"'+",1)";
		System.out.println(query);
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
		
	}

	
	
	public static void AgeConvRateoptimisation(String campaignId,String channel, String marketValue) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt = null;
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());
		
		
		//	List<SegmentCPCDTO> segmentcpc = new ArrayList<SegmentCPCDTO>();
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,ConvRate) VALUES("+"'"+date+"'"+","+"'"+campaignId+"'"+","+"'"+channel+"'"+",'Age',"+'"'+marketValue+'"'+",1)";
		System.out.println(query);
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			 stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
		
	}
	
	
	public static void GenderConvRateoptimisation(String campaignId,String channel, String marketValue) {

		String ServerConnectionURL = "jdbc:mysql://localhost:3306/idealtargetingparameters";
		String DBUser = "root";
	    String DBPass = "";
	    String DBName = "idealtargetingparameters";
		String TABLENAME = "idealtargetingparameters";
		Connection con = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt = null;
        cal.add(Calendar.DATE, -1);
		String date = dateFormat.format(cal.getTime());
		
		
		//	List<SegmentCPCDTO> segmentcpc = new ArrayList<SegmentCPCDTO>();
		String query = "INSERT INTO IdealTargetingParameters (AnalysedDate,CampaignId,Channel,OptimisationParameter,OptimumValues,ConvRate) VALUES("+"'"+date+"'"+","+"'"+campaignId+"'"+","+"'"+channel+"'"+",'Gender',"+'"'+marketValue+'"'+",1)";
		System.out.println(query);
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
        	
        	
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

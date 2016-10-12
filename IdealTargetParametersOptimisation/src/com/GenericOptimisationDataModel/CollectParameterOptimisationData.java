package com.GenericOptimisationDataModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stringutil.DBUtil;

public class CollectParameterOptimisationData {

	public static List<ParameterCTRDTO> cityCTRoptimisation(String channel) {

		/*
		String Driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://52.90.244.81:3306/datastore";
		String uName = "root";
		String pwd = "Qwerty12@";
		*/
	
		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Statement stmt = null;
		ResultSet rs = null;
		
		Connection con = null;
		List<ParameterCTRDTO> cityctr = new ArrayList<ParameterCTRDTO>();
		String query = "SELECT sum(impression) as imp,sum(clicks) as clicks,date,city,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and city !='' group by date,city,campaign_id";
        System.out.println(query);
        
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
                ParameterCTRDTO dto = new ParameterCTRDTO();
				dto.setParameter(rs.getString("city"));
				System.out.println(rs.getString("city"));
				dto.setCampaignId(rs.getString("campaign_id"));
				dto.setClicks(rs.getString("clicks"));
				dto.setImpressions(rs.getString("imp"));
				dto.setAnalyseddate(rs.getString("date"));
				cityctr.add(dto);
				
				System.out.println("Data Fetched successfully");

			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
	  return cityctr;
	}



	public static List<ParameterCTRDTO> OSCTRoptimisation(String channel) {

		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		List<ParameterCTRDTO> osctr = new ArrayList<ParameterCTRDTO>();
		String query = "SELECT sum(impression) as imp,sum(clicks) as clicks,OS,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and OS !='' group by OS,campaign_id";
        System.out.println(query);
        Statement stmt = null;
	    ResultSet rs = null;
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
		    rs = stmt.executeQuery(query);
			while (rs.next()) {
                ParameterCTRDTO dto = new ParameterCTRDTO();
                dto.setCampaignId(rs.getString("campaign_id"));
                dto.setImpressions(rs.getString("imp"));
				dto.setClicks(rs.getString("clicks"));
				dto.setParameter(rs.getString("OS"));
				osctr.add(dto);
				
				System.out.println("Data Fetched successfully");

			} 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	     return osctr;
	
	}



	public static List<ParameterCTRDTO> SegmentCTRoptimisation(String channel) {


		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ParameterCTRDTO> segmentctr = new ArrayList();
		String query = "SELECT sum(impression) as imp,sum(clicks) as clicks,audience_segment,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and audience_segment != '' group by audience_segment,campaign_id";
        System.out.println(query);
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
		    	ParameterCTRDTO dto = new ParameterCTRDTO();
                dto.setCampaignId(rs.getString("campaign_id"));
                dto.setImpressions(rs.getString("imp"));
				dto.setClicks(rs.getString("clicks"));
				dto.setParameter(rs.getString("audience_segment"));
				segmentctr.add(dto);
				
				System.out.println("Data Fetched successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	     return segmentctr;
	
	}

	
	public static List<ParameterCTRDTO> AgeCTRoptimisation(String channel) {


		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ParameterCTRDTO> segmentctr = new ArrayList();
		String query = "SELECT sum(impression) as imp,sum(clicks) as clicks,age,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and age != '' group by age,campaign_id";
        System.out.println(query);
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
		    	ParameterCTRDTO dto = new ParameterCTRDTO();
                dto.setCampaignId(rs.getString("campaign_id"));
                dto.setImpressions(rs.getString("imp"));
				dto.setClicks(rs.getString("clicks"));
				dto.setParameter(rs.getString("age"));
				segmentctr.add(dto);
				
				System.out.println("Data Fetched successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	     return segmentctr;
	
	}
	
	
	public static List<ParameterCTRDTO> GenderCTRoptimisation(String channel) {


		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ParameterCTRDTO> segmentctr = new ArrayList();
		String query = "SELECT sum(impression) as imp,sum(clicks) as clicks,gender,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and gender != '' group by gender,campaign_id";
        System.out.println(query);
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
		    stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
		    	ParameterCTRDTO dto = new ParameterCTRDTO();
                dto.setCampaignId(rs.getString("campaign_id"));
                dto.setImpressions(rs.getString("imp"));
				dto.setClicks(rs.getString("clicks"));
				dto.setParameter(rs.getString("gender"));
				segmentctr.add(dto);
				
				System.out.println("Data Fetched successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	     return segmentctr;
	
	}
	

	public static List<ParameterCPCDTO> cityCPCoptimisation(String channel) {

		
		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ParameterCPCDTO> citycpc = new ArrayList<ParameterCPCDTO>();
		String query = "SELECT sum(mediacost) as spent,sum(clicks) as clicks,city,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and city != '' group by city,campaign_id";
        System.out.println(query);
		
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {

				    ParameterCPCDTO dto = new ParameterCPCDTO();
					dto.setParameter(rs.getString("city"));
					dto.setCampaignId(rs.getString("campaign_id"));
					dto.setClicks(rs.getString("clicks"));
					dto.setSpent(rs.getString("spent"));
				 	citycpc.add(dto);
				//    System.out.println("Data Fetched successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
	    return citycpc;
	}



	public static List<ParameterCPCDTO> OSCPCoptimisation(String channel) {

		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
	    ResultSet rs = null;
	    List<ParameterCPCDTO> oscpc = new ArrayList<ParameterCPCDTO>(); 
		String query = "SELECT sum(mediacost) as spent,sum(clicks) as clicks,OS,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and OS !='' group by OS,campaign_id";
		System.out.println(query);
		
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
		    stmt = con.createStatement();
		    rs = stmt.executeQuery(query);
			while(rs.next()) {
				    ParameterCPCDTO dto = new ParameterCPCDTO();
	                dto.setCampaignId(rs.getString("campaign_id"));
	                dto.setSpent(rs.getString("spent"));
					dto.setClicks(rs.getString("clicks"));
					dto.setParameter(rs.getString("OS"));
					oscpc.add(dto);
					
			//		System.out.println("Data Fetched successfully");


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	   return oscpc;
	}



	public static List<ParameterCPCDTO> SegmentCPCoptimisation(String channel) {

		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<ParameterCPCDTO> segmentcpc = new ArrayList<ParameterCPCDTO>();
		String query = "SELECT sum(mediacost) as spent,sum(clicks) as clicks,audience_segment,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and audience_segment != '' group by audience_segment,campaign_id";
		System.out.println(query);
		
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {

				ParameterCPCDTO dto = new ParameterCPCDTO();
                dto.setCampaignId(rs.getString("campaign_id"));
                dto.setSpent(rs.getString("spent"));
				dto.setClicks(rs.getString("clicks"));
				dto.setParameter(rs.getString("audience_segment"));
				segmentcpc.add(dto);
				
		//		System.out.println("Data Fetched successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
		return segmentcpc;
	}
    
	

	public static List<ParameterCPCDTO> AgeCPCoptimisation(String channel) {

		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ParameterCPCDTO> segmentcpc = new ArrayList<ParameterCPCDTO>();
		String query = "SELECT sum(mediacost) as spent,sum(clicks) as clicks,age,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and age != '' group by age,campaign_id";
		System.out.println(query);
		
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {

				ParameterCPCDTO dto = new ParameterCPCDTO();
                dto.setCampaignId(rs.getString("campaign_id"));
                dto.setSpent(rs.getString("spent"));
				dto.setClicks(rs.getString("clicks"));
				dto.setParameter(rs.getString("age"));
				segmentcpc.add(dto);
				
		//		System.out.println("Data Fetched successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
		return segmentcpc;
	}
    

	public static List<ParameterCPCDTO> GenderCPCoptimisation(String channel) {

		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ParameterCPCDTO> segmentcpc = new ArrayList<ParameterCPCDTO>();
		String query = "SELECT sum(mediacost) as spent,sum(clicks) as clicks,gender,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and gender != '' group by gender,campaign_id";
		System.out.println(query);
		
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {

				ParameterCPCDTO dto = new ParameterCPCDTO();
                dto.setCampaignId(rs.getString("campaign_id"));
                dto.setSpent(rs.getString("spent"));
				dto.setClicks(rs.getString("clicks"));
				dto.setParameter(rs.getString("gender"));
				segmentcpc.add(dto);
				
		//		System.out.println("Data Fetched successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
		return segmentcpc;
	}
    
	
	
	
	public static List<ParameterConvCostDTO> cityConvCostoptimisation(String channel) {

		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		//	Statement stmt1 = con.createStatement();
	    ResultSet rs = null;
		
		List<ParameterConvCostDTO> cityconvcost = new ArrayList<ParameterConvCostDTO>();
		String query = "SELECT sum(spent) as spent,sum(conversions) as conversions,city,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and city != '' group by city,campaign_id";

		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
		    stmt = con.createStatement();
		//	Statement stmt1 = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {

				    ParameterConvCostDTO dto = new ParameterConvCostDTO();
					dto.setParameter(rs.getString("city"));
					dto.setCampaignId(rs.getString("campaign_id"));
					dto.setConversions(rs.getString("conversions"));
					dto.setSpent(rs.getString("spent"));
				 	cityconvcost.add(dto);
				    System.out.println("Data Fetched successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
	    return cityconvcost;
	}



	public static List<ParameterConvCostDTO> OSConvCostoptimisation(String channel) {

		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ParameterConvCostDTO> osconvcost = new ArrayList<ParameterConvCostDTO>();
		String query = "SELECT sum(spent) as spent,sum(conversions) as conversions,OS,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and OS != '' group by OS,campaign_id";

		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				    ParameterConvCostDTO dto = new ParameterConvCostDTO();
	                dto.setCampaignId(rs.getString("campaign_id"));
	                dto.setSpent(rs.getString("spent"));
					dto.setConversions(rs.getString("conversions"));
					dto.setParameter(rs.getString("OS"));
					osconvcost.add(dto);
					
					System.out.println("Data Fetched successfully");


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 

	   return osconvcost;
	}



	public static List<ParameterConvCostDTO> SegmentConvCostoptimisation(String channel) {

		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ParameterConvCostDTO> segmentconvcost = new ArrayList<ParameterConvCostDTO>();
		String query = "SELECT sum(spent) as spent,sum(conversions) as conversions,audience_segment,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and audience_segment != '' group by audience_segment,campaign_id";

		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
		    rs = stmt.executeQuery(query);
			while(rs.next()) {

				ParameterConvCostDTO dto = new ParameterConvCostDTO();
                dto.setCampaignId(rs.getString("campaign_id"));
                dto.setSpent(rs.getString("spent"));
				dto.setConversions(rs.getString("conversions"));
				dto.setParameter(rs.getString("audience_segment"));
				segmentconvcost.add(dto);
				
				System.out.println("Data Fetched successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
		return segmentconvcost;
	}
	
	
	public static List<ParameterConvCostDTO> AgeConvCostoptimisation(String channel) {

		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ParameterConvCostDTO> segmentconvcost = new ArrayList<ParameterConvCostDTO>();
		String query = "SELECT sum(spent) as spent,sum(conversions) as conversions,age,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and age != '' group by age,campaign_id";

		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {

				ParameterConvCostDTO dto = new ParameterConvCostDTO();
                dto.setCampaignId(rs.getString("campaign_id"));
                dto.setSpent(rs.getString("spent"));
				dto.setConversions(rs.getString("conversions"));
				dto.setParameter(rs.getString("age"));
				segmentconvcost.add(dto);
				
				System.out.println("Data Fetched successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
		return segmentconvcost;
	}
	
	public static List<ParameterConvCostDTO> GenderConvCostoptimisation(String channel) {

		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ParameterConvCostDTO> segmentconvcost = new ArrayList<ParameterConvCostDTO>();
		String query = "SELECT sum(spent) as spent,sum(conversions) as conversions,gender,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and gender != '' group by gender,campaign_id";

		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {

				ParameterConvCostDTO dto = new ParameterConvCostDTO();
                dto.setCampaignId(rs.getString("campaign_id"));
                dto.setSpent(rs.getString("spent"));
				dto.setConversions(rs.getString("conversions"));
				dto.setParameter(rs.getString("gender"));
				segmentconvcost.add(dto);
				
				System.out.println("Data Fetched successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
		return segmentconvcost;
	}
	
	
	
	public static List<ParameterConvRateDTO> cityConvRateoptimisation(String channel) {

		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ParameterConvRateDTO> cityconvrate = new ArrayList<ParameterConvRateDTO>();
		String query = "SELECT sum(impression) as impressions,sum(conversions) as conversions,city,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and city != '' group by city,campaign_id";
        System.out.println(query);
		
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {

				    ParameterConvRateDTO dto = new ParameterConvRateDTO();
					dto.setParameter(rs.getString("city"));
					dto.setCampaignId(rs.getString("campaign_id"));
					dto.setConversions(rs.getString("conversions"));
					dto.setImpressions(rs.getString("impressions"));
				 	cityconvrate.add(dto);
				    System.out.println("Data Fetched successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
	    return cityconvrate;
	}



	public static List<ParameterConvRateDTO> OSConvRateoptimisation(String channel) {


		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ParameterConvRateDTO> osconvrate = new ArrayList<ParameterConvRateDTO>();
		String query = "SELECT sum(impression) as impressions,sum(conversions) as conversions,OS,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and OS != '' group by OS,campaign_id";
        System.out.println(query);
		
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				    ParameterConvRateDTO dto = new ParameterConvRateDTO();
	                dto.setCampaignId(rs.getString("campaign_id"));
	                dto.setImpressions(rs.getString("impressions"));
					dto.setConversions(rs.getString("conversions"));
					dto.setParameter(rs.getString("OS"));
					osconvrate.add(dto);
					
					System.out.println("Data Fetched successfully");


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	   return osconvrate;
	}



	public static List<ParameterConvRateDTO> SegmentConvRateoptimisation(String channel) {

		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ParameterConvRateDTO> segmentconvrate = new ArrayList<ParameterConvRateDTO>();
		String query = "SELECT sum(impression) as impressions,sum(conversions) as conversions,audience_segment,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and audience_segment != '' group by audience_segment,campaign_id";
        System.out.println(query);
		
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
		    rs = stmt.executeQuery(query);
			while(rs.next()) {

				ParameterConvRateDTO dto = new ParameterConvRateDTO();
                dto.setCampaignId(rs.getString("campaign_id"));
                dto.setImpressions(rs.getString("impressions"));
				dto.setConversions(rs.getString("conversions"));
				dto.setParameter(rs.getString("audience_segment"));
				segmentconvrate.add(dto);
				
				System.out.println("Data Fetched successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
		return segmentconvrate;
	}
	
	
	
	public static List<ParameterConvRateDTO> AgeConvRateoptimisation(String channel) {

		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ParameterConvRateDTO> segmentconvrate = new ArrayList<ParameterConvRateDTO>();
		String query = "SELECT sum(impression) as impressions,sum(conversions) as conversions,age,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and age != '' group by age,campaign_id";
        System.out.println(query);
		
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
		    rs = stmt.executeQuery(query);
			while(rs.next()) {

				ParameterConvRateDTO dto = new ParameterConvRateDTO();
                dto.setCampaignId(rs.getString("campaign_id"));
                dto.setImpressions(rs.getString("impressions"));
				dto.setConversions(rs.getString("conversions"));
				dto.setParameter(rs.getString("age"));
				segmentconvrate.add(dto);
				
				System.out.println("Data Fetched successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
		return segmentconvrate;
	}
	
	public static List<ParameterConvRateDTO> GenderConvRateoptimisation(String channel) {

		String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/datastore";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "datastore";
		String TABLENAME = "datawarehouse";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ParameterConvRateDTO> segmentconvrate = new ArrayList<ParameterConvRateDTO>();
		String query = "SELECT sum(impression) as impressions,sum(conversions) as conversions,gender,campaign_id FROM datawarehouse where channel like '%"+channel+"%' and gender != '' group by gender,campaign_id";
        System.out.println(query);
		
		try {
			con = DriverManager.getConnection(ServerConnectionURL,
					DBUser, DBPass);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {

				ParameterConvRateDTO dto = new ParameterConvRateDTO();
                dto.setCampaignId(rs.getString("campaign_id"));
                dto.setImpressions(rs.getString("impressions"));
				dto.setConversions(rs.getString("conversions"));
				dto.setParameter(rs.getString("gender"));
				segmentconvrate.add(dto);
				
				System.out.println("Data Fetched successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
        	DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
			
		} 
	
	
		return segmentconvrate;
	}
	
	
	
	
	
	
	
}

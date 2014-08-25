package com.shabi.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.shabi.database.MySQLConnection;
import com.shabi.forms.PostJobDTO;

public class PostJobRequestDAO {
	private Connection conn = MySQLConnection.getConnection();
	private int jobId;
	
	public int postJob(PostJobDTO job) {
		
		String userId = job.getId();
		String skill = job.getSkill();
		String experience = job.getExperience();
		String jobTitle = job.getJobTitle();
		String description = job.getDescription();
		String client = job.getClient();
		int records = 0;
		
		String post_job_query = "INSERT INTO job(USER_ID, SKILLS, EXPERIENCE, " +
		"JOB_TITLE, DESCRIPTION, CLIENT) " +
		"VALUES ('"+userId+"', '"+skill+"', '"+experience+"', '"+jobTitle+"', " +
		"'"+description+"', '"+client+"')";
		System.out.println("Query fired is post_job_query : " + post_job_query);
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(post_job_query);
			records = ps.executeUpdate(post_job_query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("exception from post_job_query");
		} 
		String query_last_inserted_job_id = "SELECT MAX(ID) FROM JOB";
		System.out.println(" query_last_inserted_job_id fired = " + query_last_inserted_job_id );
		PreparedStatement ps1;
		try {
			ps1 = conn.prepareStatement(query_last_inserted_job_id);
			ResultSet rs = ps1.executeQuery(query_last_inserted_job_id);
			while(rs.next()){
				 //jobId = rs.getInt(1);
			
				 rs.getInt(1);
				 job.setJobId(rs.getInt(1));
				 System.out.println("Last inserted job id is : " + jobId);
				 
				 //request.setAttribute("jobId", jobId);
			}
			
		} catch (SQLException e) {
			System.out.println(" exception from query_last_inserted_job_id ----" + query_last_inserted_job_id);
			e.printStackTrace();
		}
		
		finally {
			try {
				if (conn != null ){
					conn.close();					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		
		return jobId;
	}
	
	
	
	
	

}

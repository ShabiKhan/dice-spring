package com.shabi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shabi.database.MySQLConnection;
import com.shabi.forms.SearchJobResponseDTO;;

public class SearchJobDAO {
	
	private Connection conn;

	public List<SearchJobResponseDTO> getJobs(String skill, int userId){
		conn = MySQLConnection.getConnection();
	
		String searchedJobResultQuery = "SELECT JOB.ID, JOB.JOB_TITLE, RECRUITER.EMPLOYER, JOB.CLIENT" +
		" FROM JOB, recruiter" +
		" WHERE RECRUITER.USER_ID = JOB.USER_ID" +
		" AND JOB.SKILLS LIKE '%"+skill+"%'";
		System.out.println("\n\n Query fired is searchedJobResultQuery " + searchedJobResultQuery);
		List<SearchJobResponseDTO> jobs = new ArrayList<SearchJobResponseDTO>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(searchedJobResultQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				SearchJobResponseDTO jobDTO = new SearchJobResponseDTO();
				String jobId = rs.getString("ID");
				jobDTO.setId(jobId);
				jobDTO.setClient(rs.getString("CLIENT"));
				jobDTO.setEmployer(rs.getString("EMPLOYER"));;
				jobDTO.setJobTitle(rs.getString("JOB_TITLE"));
				
				String jobsAppliedQuery = "select * FROM job_application " +
				"WHERE USER_ID = '"+userId+"' " +
				"AND JOB_ID = '"+jobId+"' ";
				System.out.println("\n\n Query fired is jobsAppliedQuery " + jobsAppliedQuery);
				PreparedStatement ps1 = conn.prepareStatement(jobsAppliedQuery);
				ResultSet rs1 = ps1.executeQuery(jobsAppliedQuery);
				jobDTO.setApplied(rs1.next());
				jobs.add(jobDTO);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobs;
		
	}

}

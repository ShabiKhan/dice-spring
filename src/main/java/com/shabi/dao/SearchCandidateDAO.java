package com.shabi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shabi.database.MySQLConnection;
import com.shabi.forms.SearchCandidateDTO;

public class SearchCandidateDAO {
	private Connection conn = MySQLConnection.getConnection();
	private String skill;
	
	public  List <SearchCandidateDTO> searchCandidate(String skill) {
		String search_candidate_query = "SELECT USER.ID, USER.NAME, JOB_SEEKER.EXPERIENCE, JOB_SEEKER.SKILLS " +
										"FROM USER, JOB_SEEKER " +
										"WHERE USER.ID = JOB_SEEKER.USER_ID " +
										"AND JOB_SEEKER.SKILLS LIKE '%"+skill+"%'";
		
		System.out.println("Query fired is search_candidate_query : " + search_candidate_query);
		PreparedStatement ps;
		List <SearchCandidateDTO> candidates = new ArrayList <SearchCandidateDTO>();
		try {
			ps = conn.prepareStatement(search_candidate_query);
			ResultSet rs = ps.executeQuery(search_candidate_query);
			while (rs.next()){
				SearchCandidateDTO canDTO = new SearchCandidateDTO();
				
				canDTO.setName(rs.getString("NAME"));
				canDTO.setId(rs.getString("ID"));
				canDTO.setExperience(rs.getString("EXPERIENCE"));
				canDTO.setSkills(rs.getString("SKILLS"));
				candidates.add(canDTO);
			}

		} catch (SQLException e) {
			System.out.println(" exception from search_candidate_query " + search_candidate_query );
			e.printStackTrace();
		}
		finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("Exception from SearchCandidateDAO in finally block");
					e.printStackTrace();
				}
			}
		}
		return candidates;
	}

}

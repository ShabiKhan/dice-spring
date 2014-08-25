package com.shabi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shabi.forms.UserDTO;
import com.shabi.database.*;

public class UserDAO {
	private UserDTO usr;
	private Connection conn = MySQLConnection.getConnection();
	
	public boolean authenticateUser(String email, String password){
		System.out.println("From authenticateUser email =" + email + " \n password : " +password );				
		String authenticateUserQuery = "SELECT PASSWORD, ROLE, NAME FROM USER " +
										"WHERE EMAIL = '"+email+"'";
		System.out.println("\n\n Query fired is authenticateUserQuery " + authenticateUserQuery);
		usr = new UserDTO();
		
		try {
			PreparedStatement ps = conn.prepareStatement(authenticateUserQuery);
			ResultSet rs = ps.executeQuery(authenticateUserQuery);
			if(rs.next()) {
				String password_db = rs.getString("PASSWORD");
				
				if(password.equals(password_db)) {
					usr.setPassword(password_db);
					usr.setRole(rs.getString("ROLE"));
					String role = usr.getRole();
					System.out.println("role is : " + role);
					usr.setName(rs.getString("NAME"));
					usr.setEmail(email);
				} else {
					return false;   //bcoz user entered wrong paswword
				}
			} else {
				return false;   //means user doest not even exist
			}
		} catch (SQLException e) {
			System.out.println("exception from authenticateUserQuery");
			e.printStackTrace();
		}
		return true;
	}
	
	public UserDTO getUserProfile() {
		System.out.println(usr.getRole());
		try {
			if (usr.getRole().equals("job_seeker")) {   // means role=jobseeker 
				String saveJobSeekerInSessionQuery = "SELECT USER.ID, USER.NAME, USER.EMAIL, USER.PASSWORD, " +
												"USER.DOB, USER.GENDER, USER.ROLE, JOB_SEEKER.SKILLS, " +
												"JOB_SEEKER.EXPERIENCE " +
												"FROM job_seeker, USER " +
												"WHERE JOB_SEEKER.USER_ID = USER.ID " +
												"AND USER.EMAIL = '" + usr.getEmail() + "'";
				System.out.println("\n\n Query fired is saveJobSeekerInSessionQuery" + saveJobSeekerInSessionQuery);
				PreparedStatement ps1 = conn.prepareStatement(saveJobSeekerInSessionQuery);
				ResultSet rs1 = ps1.executeQuery(saveJobSeekerInSessionQuery);
					while(rs1.next()){
						usr.setId(rs1.getInt("ID"));
						//usr.setName(rs1.getString("NAME"));
						//usr.setEmail(rs1.getString("EMAIL"));
						usr.setDob(rs1.getString("DOB"));
						usr.setGender(rs1.getString("GENDER"));
						//usr.setRole(rs1.getString("ROLE"));
						usr.setSkills(rs1.getString("SKILLS"));
						usr.setExperience(rs1.getInt("EXPERIENCE"));				
					}
			} else {  //means role is receruiter, save user as receruiter
				String recruiter_query = "SELECT USER.ID, USER.NAME, USER.EMAIL, USER.PASSWORD, " +
										"USER.DOB, USER.GENDER, USER.ROLE, " +
										"RECRUITER.EMPLOYER FROM RECRUITER," +
										"USER WHERE RECRUITER.USER_ID = USER.ID " +
										"AND USER.EMAIL = '" + usr.getEmail() + "'"; 
				System.out.println("\n\n recruiter_query = "+ recruiter_query);
				PreparedStatement ps2 = conn.prepareStatement(recruiter_query);
				ResultSet rs2 = ps2.executeQuery(recruiter_query);
				while (rs2.next()){
					usr.setId(rs2.getInt("ID"));
					//usr.setName(rs2.getString("NAME"));
					//usr.setEmail(rs2.getString("EMAIL"));
					usr.setDob(rs2.getString("DOB"));
					usr.setGender(rs2.getString("GENDER"));
					//usr.setRole(rs2.getString("ROLE"));
					usr.setEmployer(rs2.getString("EMPLOYER"));
				}
			}
			conn.close();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return usr;
	}

}

package com.shabi.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.shabi.database.MySQLConnection;
import com.shabi.forms.RegisterUserRequestDTO;

public class RegisterUserRequestDAO {
	private Connection conn = MySQLConnection.getConnection();
	
	public int registerUser(RegisterUserRequestDTO user){
		
		System.out.println(" connection conn is " + conn);
		
		String username = user.getName();
		String dob = user.getDob();
		String email = user.getEmail();
		String emp = user.getEmployer();
		String exp = user.getExperience();
		String role = user.getRole();
		String sex = user.getGender();
		String skills = user.getSkills();
		String password = user.getPassword();
		int records = 0;
		String insertUserQuery ="INSERT INTO user(NAME, EMAIL, PASSWORD, DOB, GENDER, ROLE)" +
		" VALUES('"+username+"', '"+email+"', '"+password+"'," +
				" '"+dob+"', '"+sex+"', '"+role+"')" ;
		PreparedStatement ps;
		System.out.println("\n\n query fired is insertUserQuery = " + insertUserQuery);
		try {
			ps=conn.prepareStatement(insertUserQuery);
			records = ps.executeUpdate(insertUserQuery);
		} catch (SQLException e) {
			System.out.println("exception from insertUserQuery");
			e.printStackTrace();
		}
		System.out.println(" skills ================= [" + skills +"]");
		if (!(skills.equals("") ) || !(exp.equals("")) ){// this means register as jobSeeker
			records += registerAsJobSeeker(user);
		}
		else{//this means register as recruiter
			records += registerAsRecruiter(user);
		}
		return records;
		
	}

	private int registerAsRecruiter(RegisterUserRequestDTO usersDTO) {
		String emp = usersDTO.getEmployer();
		String recruiterQuery = "INSERT INTO recruiter(USER_ID, EMPLOYER) " +
				"VALUES( LAST_INSERT_ID(), '"+emp+"')";
		PreparedStatement ps2;
		System.out.println("\n\n Query fired is recruiterQuery " + recruiterQuery);
		int records = 0;
		try {
			ps2 = conn.prepareStatement(recruiterQuery);
			records = ps2.executeUpdate(recruiterQuery);
		} catch (SQLException e) {
			System.out.println("\n\n Exception from recruiterQuery "+ recruiterQuery);	
			e.printStackTrace();
		}		
		return records;
	}

	private int registerAsJobSeeker(RegisterUserRequestDTO usersDTO) {
		String exp = usersDTO.getExperience();
		String skills = usersDTO.getSkills();
		
		String jobSeekerQuery = "INSERT INTO job_seeker(USER_ID, SKILLS, EXPERIENCE) " +
				"VALUES( LAST_INSERT_ID(), '"+skills+"','"+exp+"')";
		PreparedStatement ps1;
		System.out.println("\n\n Query fired is jobSeekerQuery "+ jobSeekerQuery);
		int records = 0;
		try {
			ps1 = conn.prepareStatement(jobSeekerQuery);
			records = ps1.executeUpdate(jobSeekerQuery);
		} catch (SQLException e) {
			System.out.println("\n\n Exception from jobSeekerQuery "+ jobSeekerQuery);			
			e.printStackTrace();
		}		
		return records;
	}
}

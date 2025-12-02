package com.restapiproject.hotelManagement.auth;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
 
@Repository  // - DAO
public class UserRepository {
	
	// responsible for interacting with user table
	// check - username already existing
	// fetch a user by username
	// insert a new user
	
	private final JdbcTemplate jdbcTemplate; 	
	private final RowMapper<User> userRowMapper = (rs, rowNum) -> {
		User u = new User();
		u.setId(rs.getInt("id"));
		u.setUsername(rs.getString("username"));
		u.setPassword(rs.getString("password"));
		u.setRole(rs.getString("role"));
		return u;
	};
	public UserRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}	
	// Method to check username exists
	public boolean existsByusername(String username) {
		Integer cnt = jdbcTemplate.queryForObject("Select count(*) from users where username =?", Integer.class, username);
		return cnt != null && cnt > 0;
		// count > 0 -> username already exists -> true
		// used to prevent duplicate users		
	}	
	// Method - fetch user ny username
	public User findByUsername(String username) {
		try {
			return jdbcTemplate.queryForObject("Select * from users where username=?",userRowMapper, username);
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}	
	// Method - Save new user
	public int save(User user) {
		return jdbcTemplate.update("Insert into users (username, password, role) Values (?,?,?)",
				user.getUsername(), user.getPassword(), user.getRole());
	}    
}



/*
<!-- Spring Security -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>
 
<!-- JJWT (io.jsonwebtoken) - add the implementation + jackson -->
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-api</artifactId>
  <version>0.11.5</version> <!-- check for latest -->
</dependency>
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-impl</artifactId>
  <version>0.11.5</version>
  <scope>runtime</scope>
</dependency>
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-jackson</artifactId>
  <version>0.11.5</version>
  <scope>runtime</scope>
</dependency>
*/


/*
 * JWT -> JSON Web Token
 * -> compact token -> verify : who the user is (identity)
 *                            : what the user is allowed to do (authorization)
 *                            : whether the token is valid ans unmodified
 * structure : 3 parts : xxxxx.yyyyy.zzzzz
 * Header : what algorithm was used to sign it
 * Payload : usernames, roles, expiry
 * Signature :  ensures token is not tampered
 *
 * Why?
 *
 * -> REst APis
 * -> Secure Rest APis
 * -> EAsy authorization - inside some roles - admin, user
 * -> adding security to Rest APis
 *
 * User Register -> end point -> POST auth/register -> username, pwd, role
 *               -> encode the password - BCryptPasswordEncoder
 *               -> Store in MySQL using jdbcTemplate
 *               -> user is registeres
 *               -> Created user who can authenticate now
 * User login -> end point -> POST auth/login - name, pwd
 *            -> compare raw pwd with encoded pwd
 *            -> If valid -> generate JWT Token
 *            -> username , role, expiry taken, secret key
 *            -> token now -> user's identity
 * CLinet sends token in request -> GET /api/hotels -> fetch this
 *             -> send authorisation header also
 * JWT filter -> extract token from authorisation
 *           -> validate token
 * Security COnfig -> admin -> POST, PUT, Delete
 *                 -> user -> to do only GET
 *                 -> roles -> what kind of access is specified
 *                 -> Controller runs - execute allowed API           
 *           
 * ROLE_admin, ROLE_user
 *
 * JWT -> once you login -> you JWT -> authetication
 *     -> request -> then authorizes based on role
 *                                        
 */
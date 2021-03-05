package com.wcp.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.domain.Product;
import com.wcp.beans.User;

@Repository
public class DatabaseAccess {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public NamedParameterJdbcTemplate jdbc;
	
	public ArrayList<Product> getAllProducts(){
		
		ArrayList<Product> products = new ArrayList<Product>();
		String query = "Select * from ProductList";
		products = (ArrayList<Product>)this.jdbc.query(query, 
				new BeanPropertyRowMapper<Product>(Product.class));
		return products;
	}
	
	public User findUserAccount(String userName) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		String query = "SELECT * FROM sec_user WHERE userName=:userName";
		params.addValue("userName", userName);
		ArrayList<User> users = (ArrayList<User>)jdbc.query(query, params, 
				new BeanPropertyRowMapper<User>(User.class));
		
		if(users.size()>0) 
			return users.get(0);
		return null;
	}
	
	public List<String> getRolesById(long userId){
		ArrayList<String> roles = new ArrayList<String>();
		MapSqlParameterSource params = new MapSqlParameterSource();
		String query ="SELECT user_role.userId, sec_role.roleName "
				+"FROM user_role, sec_role "
				+"WHERE user_role.roleId=sec_role.roleId "
				+"AND userId=:userId";
		params.addValue("userId", userId);
		List<Map<String, Object>> rows = jdbc.queryForList(query, params);
		for(Map<String, Object> row: rows) {
			roles.add((String)row.get("roleName"));
		}
		return roles;
	}
	
	public void createNewUser(String userName, String password) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		String query = "insert into SEC_User (userName, encryptedPassword, ENABLED)\r\n" + 
				"values (:name, :pass, 1)";
		params.addValue("name", userName);
		params.addValue("pass",passwordEncoder.encode(password));
		jdbc.update(query, params);
	}
	
	public void addRole(long userId, long roleId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		String query = "insert into user_role (userId, roleId)\r\n" + 
				"values (:userId, :roleId);";
		params.addValue("userId", userId);
		params.addValue("roleId", roleId);
		jdbc.update(query, params);
	}
	

}
package com.wcp.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.wcp.database.DatabaseAccess;

public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	@Lazy
	private DatabaseAccess da;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.wcp.beans.User user = da.findUserAccount(username);
		if(user==null) {
			System.out.print("Cannot find user: "+ username);
			throw new UsernameNotFoundException("User "+ username+" not found");
			
		}
		
		List<String> roles = da.getRolesById(user.getUserId());
		List<GrantedAuthority> grants = new ArrayList<GrantedAuthority>();
		for(String grant: roles) {
			grants.add(new SimpleGrantedAuthority(grant));
		}
		
		UserDetails userDetails = (UserDetails) new User(user.getUserName(),
				user.getEncryptedPassword(), grants);
		
		return userDetails;
	}
}

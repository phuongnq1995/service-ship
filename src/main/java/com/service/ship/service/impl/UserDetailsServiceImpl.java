package com.service.ship.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.service.ship.entity.User;
import com.service.ship.model.user.UserDetailsImpl;
import com.service.ship.repository.RoleRepository;
import com.service.ship.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);

		if (user == null) {

			throw new UsernameNotFoundException(username);
		}

		Collection<GrantedAuthority> authorities = 
			AuthorityUtils.createAuthorityList(
				roleRepository.findRoleNameByUserId(user.getId())
					.toArray(new String[0]));
	
		return new UserDetailsImpl(user, authorities);
	}
}

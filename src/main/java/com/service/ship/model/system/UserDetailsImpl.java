package com.service.ship.model.system;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.service.ship.entity.User;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = -2663773094251354234L;

	private final User user;

	private final Collection<GrantedAuthority> authorities;

	public UserDetailsImpl(User user,
			Collection<GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
	}

	public String getPassword() {
		return user.getPassword();
	}

	public String getUsername() {
		return user.getUsername();
	}

	public boolean isEnabled() {
		return user.isEnabled();
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public User getUser() {
		return user;
	}
}

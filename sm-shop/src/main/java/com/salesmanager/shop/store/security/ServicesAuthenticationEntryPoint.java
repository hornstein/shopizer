<<<<<<< HEAD
package com.salesmanager.shop.store.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServicesAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence( HttpServletRequest request, HttpServletResponse response, 
			AuthenticationException authException ) throws IOException{
		response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );
	}

=======
package com.salesmanager.shop.store.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServicesAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence( HttpServletRequest request, HttpServletResponse response, 
			AuthenticationException authException ) throws IOException{
		response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );
	}

>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
}
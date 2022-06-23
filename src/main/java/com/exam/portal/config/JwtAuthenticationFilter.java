package com.exam.portal.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exam.portal.service.impl.UserDetailsServiceImpl;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
			final String requestTokenHeader = request.getHeader("Authorization");
			String username=null;
			String jwtToken=null;
			
			if (requestTokenHeader!=null && requestTokenHeader.startsWith("Bearers ")) {
				jwtToken=requestTokenHeader.substring(7);
				username=this.jwtUtils.extractUsername(jwtToken);
				
			}
			else {
				
			}
			
			if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				final UserDetails userDetails =this.userDetailsServiceImpl.loadUserByUsername(username);
				
				if (jwtUtils.validateToken(jwtToken, userDetails)) {
					
					UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
					}

			}else {
				System.out.println("token not valid");
			}
			
			filterChain.doFilter(request, response);
			
	}

}

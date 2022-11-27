package com.mandu.yamyam.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class WebAccessDenyHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
		AccessDeniedException accessDeniedException) throws IOException, ServletException {
//		System.out.println(accessDeniedException.getMessage());
//		System.out.println(accessDeniedException.getCause());
		request.getRequestDispatcher("/error403").forward(request, response);
	}

}

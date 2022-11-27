package com.mandu.yamyam.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.mandu.yamyam.comm.service.EmpVO;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		EmpVO vo = new EmpVO();
		// vo = service.empSelect(autentication.getName()) 직원 아이디로 찾아오기
		/*
		 request.getSession().setAttribute("empNo", vo.getEmpNo);
		 request.getSession().setAttribute("empId", vo.getEmpId);
		 request.getSession().setAttribute("empRole", vo.getEmpRole);
		  */
		response.sendRedirect(request.getContextPath() + "/main");

	}
}

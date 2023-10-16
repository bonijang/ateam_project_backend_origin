/*
 * 작성자: 장보늬
 * 작성일자: 2023-10-15
 * 내용: 공통예외 처리를 총 관리합니다.
 */

package com.ktdsuniversity.edu.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PageNotFoundException.class)
	public String viewErrorPage(PageNotFoundException runtimeException, Model model) {
		model.addAttribute("message", runtimeException.getMessage());
		return "error/404";
	}
	
	@ExceptionHandler({FileNotExistsException.class
		             , MakeXlsxFileException.class
		             , RuntimeException.class})
	public String viewErrorPage(RuntimeException runtimeException, Model model) {
		model.addAttribute("message", runtimeException.getMessage());
		return "error/500";
	}
	
	@ExceptionHandler(AlreadyUseException.class)
	public String viewMemberRegistErrorPage(AlreadyUseException exception, Model model) {
		model.addAttribute("memberVO", exception.getMemberVO());
		return "member/membersignup";
	}
	
	@ExceptionHandler(UserIdentityNotMatchException.class)
	public String viewUserIdentityNotMatchExceptionErrorPage(
			                    UserIdentityNotMatchException exception
			                  , Model model) {
		model.addAttribute("memberVO", exception.getMemberVO());
		model.addAttribute("message", exception.getMessage());
		return "member/memberlogin";
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String viewMethodArgumentNotValidExceptionErrorPage(
			  MethodArgumentNotValidException runtimeException
			, Model model) {
		model.addAttribute("message", runtimeException.getMessage());
		return "error/404";
	}
}

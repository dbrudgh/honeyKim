package com.hb.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {
	
	@Autowired
	private MemberDAO dao;
	
	public ChangePasswordService() {
		// TODO Auto-generated constructor stub
	}
	
	public ChangePasswordService(MemberDAO dao) {
		this.dao = dao;
	}
	
	public void changePassword(String email, String oldPwd, String newPwd){
		MemberVO vo = dao.selectByEmail(email);
		if(vo == null){
			throw new MemberNotFoundException();
		}
		vo.changePassword(oldPwd, newPwd);
		
		dao.update(vo);
	}
	
}

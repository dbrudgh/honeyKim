package com.hb.spring;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {

	private MemberDAO dao;
	
	@Autowired
	public MemberRegisterService(MemberDAO dao) {
		this.dao = dao;
	}
	
	public void register(RegisterRequest req){
		//정보확인
		MemberVO vo = dao.selectByEmail(req.getEmail()); 
		if(vo !=null){
			throw new AlreadyExistingMemberException("email : " + req.getEmail());
		}
		//맞으면 넣고 틀리면 Exception
		MemberVO newvo = new MemberVO(req.getEmail(), req.getPassword(), req.getName(), new Date());
		dao.insert(newvo);
	}
}
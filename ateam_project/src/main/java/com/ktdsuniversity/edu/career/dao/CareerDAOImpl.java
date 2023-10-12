package com.ktdsuniversity.edu.career.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.career.vo.CareerVO;
@Repository
public class CareerDAOImpl extends SqlSessionDaoSupport implements CareerDAO {
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	@Override
	public int createNewCareer(CareerVO careerVO) {
		return getSqlSession().insert("createNewCareer",careerVO );
	}
	@Override
	public CareerVO getOneCareer(String careerId) {
		return getSqlSession().selectOne("getOneCareer", careerId);
	}
	@Override
	public int updateOneCarrer(CareerVO careerVO) {
		return getSqlSession().update("updateOneCarrer", careerVO);
	}
	@Override
	public int deleteOneCareer(String careerId) {
		return getSqlSession().delete("deleteOneCareer",careerId);
	}
	@Override
	public List<CareerVO> getAllCareerList() {
		return getSqlSession().selectList("getAllCareerList");
	}

}

package com.ktdsuniversity.edu.myalgorithm.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.myalgorithm.vo.MyAlgorithmVO;

@Repository
public class MyAlgorithmDAOImpl extends SqlSessionDaoSupport implements MyAlgorithmDAO {
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int getAllNumber(String email) {
		return getSqlSession().selectOne("getAllNumber", email);
	}

	@Override
	public List<MyAlgorithmVO> getAllMyAlgorithmList(String email) {
		return getSqlSession().selectList("getAllMyAlgorithmList", email);
	}
}
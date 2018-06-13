package com.mybatis.services;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.domain.Tutor;
import com.mybatis.mappers.TutorMapperEl;
import com.mybatis.util.MyBatisSqlSessionFactory;

public class TutorServiceEl {

	public Tutor findTutorById(int tutorId) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			TutorMapperEl tutorMapper = sqlSession.getMapper(TutorMapperEl.class);
			return tutorMapper.findTutorById(tutorId);
		} finally {
			sqlSession.close();
		}
	}
	
	
}

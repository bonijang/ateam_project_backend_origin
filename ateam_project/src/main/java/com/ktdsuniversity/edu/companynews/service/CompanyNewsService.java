/*
 * 작성자: 장보늬
 * 작성일자: 2023-10-15
 * 내용: 기업소식 게시판의 CRUD 실행결과를 저장합니다.
 */

package com.ktdsuniversity.edu.companynews.service;

import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.edu.companynews.vo.CompanyNewsListVO;
import com.ktdsuniversity.edu.companynews.vo.CompanyNewsVO;

public interface CompanyNewsService {
	
	// 기업소식 게시글 목록과 게시글의 건수를 모두 조회한다.
	public CompanyNewsListVO getAllCompanyNews();

	public boolean createNewCompanyNews(CompanyNewsVO companyNewsVO, MultipartFile file);
	
	public CompanyNewsVO getOneCompanyNews(String companyNewsPostId, boolean isIncrease);
	
	public boolean updateOneCompanyNews(CompanyNewsVO companyNewsVO, MultipartFile file);
	
	public boolean deleteOneCompanyNews(String companyNewsPostId);
}

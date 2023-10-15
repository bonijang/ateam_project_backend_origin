package com.ktdsuniversity.edu.companynews.vo;

import com.ktdsuniversity.edu.member.vo.MemberVO;

import jakarta.validation.constraints.NotBlank;


public class CompanyNewsVO {
	
	private String companyNewsPostId;
	private String postWriter;
	
	@NotBlank(message = "제목을 입력해주세요.")
	private String postTitle;
	
	@NotBlank(message = "내용을 입력해주세요.")
	private String postContent;
	
	private String postDate;
	
	//@NotNull(message = "대표이미지를 첨부해주세요.")
	private String fileName;
	
	//@NotNull(message = "대표이미지를 첨부해주세요.")
	private String originFileName;
	
	private int viewCnt;
	private int likeCnt;
	private String deleteYn;


	private MemberVO memberVO;
	
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	
	public String getCompanyNewsPostId() {
		return companyNewsPostId;
	}
	public void setCompanyNewsPostId(String companyNewsPostId) {
		this.companyNewsPostId = companyNewsPostId;
	}
	public String getPostWriter() {
		return postWriter;
	}
	public void setPostWriter(String postWriter) {
		this.postWriter = postWriter;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	
}

package com.yedam.web.board.service;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
//	create table board(
//		    bno NUMBER PRIMARY KEY,
//		    title VARCHAR2(1000) NOT NULL,
//		    contents VARCHAR2(4000),
//		    writer VARCHAR2(500) NOT NULL,
//		    regdate DATE DEFAULT sysdate NOT NULL,
//		    updatedate DATE DEFAULT sysdate,
//		    image VARCHAR2(4000)
//		);
	
	private int bno;            //게시글 번호 -pr
	private String title;		//게시글 제목 -not null
	private String contents;	//작성내용
	private String writer;		//작성자 - not null        //db에서 sysdate 가 되어있으면 등록할때 굳이 값을 넣을 필요없다.
	//기본 : yyyy/MM/dd -> input[type=date] : yyyy-MM-dd
	@DateTimeFormat(pattern = "yyyy-MM-dd")   //input에 값을 이렇게 받겠다
	private Date regdate;		//등록일자 -not null
	@DateTimeFormat(pattern = "yyyy-MM-dd")  //입력하는것에 대해서만 처리하는것
	private Date updatedate;	//수정일자
	private String image;		//첨부파일
	

}

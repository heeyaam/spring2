package com.yedam.web.board.service;


import java.util.Date;

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
	private Date regdate;		//등록일자 -not null
	private Date updatedate;	//수정일자
	private String image;		//첨부파일
	

}

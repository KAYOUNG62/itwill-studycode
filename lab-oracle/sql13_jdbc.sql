-- JDBC(Java Database Connectivity):
-- Java 프로그램에서 데이터베이스 시스템에 접속해서 SQL(select/insert/update/delete) 문장을 실행

-- 블로그 테이블: BLOGS
--  BLOG_NO: 블로그 글 번호.  number(4). Primary key. 
--  TITLE: 블로그의 글 제목.  varchar2(100 char). not null
--  CONTENT: 블로그 글 내용(본문).  varchar2(1000 char). not null
--  AUTHOR: 블로그 글 작성자.  varchar2(100 char). not null
--  CREATED_DATE: 블로그 글 작성 시간.  timestamp. 기본값= 시스템 현재 시간. sysdate
--  MODIFIED_DATE: 블로그 글 수정 시간.  timestamp. 기본값= 시스템 현재 시간.

CREATE TABLE BLOGS (
    BLOG_NO         number(4), 
    TITLE           varchar2(100 char),
    CONTENT         varchar2(1000 char),
    AUTHOR          varchar2(100 char),
    CREATED_DATE    TIMESTAMP DEFAULT sysdate,
    MODIFIED_DATE   TIMESTAMP DEFAULT sysdate,
    
    CONSTRAINT BLOGS_NO_PK PRIMARY KEY(BLOG_NO),
    CONSTRAINT BLOGS_TITLE_NN check(TITLE is not null),
    CONSTRAINT BLOGS_CONTENT_NN check(CONTENT is not null),
    CONSTRAINT BLOGS_AUTHOR_NN check(AUTHOR is not null)
);

-- 테이블 편집(alter table):
-- BLOGS 테이블에서 오른쪽 클릭 > 편집 > BLOGS_NO컬럼 선택 > ID열 > 유형: 열 시퀀스 > 확인
-- 시퀀스(sequence): 자동으로 생성되는 (연속된)숫자(1, 2, 3, ...)
-- BLOGS 테이블에 데이터를 저장(insert)할 때 PK에 시퀀스가 자동으로 저장되도록 하기 위해서.

INSERT INTO blogs (TITLE , CONTENT, AUTHOR)
VALUES ('테스트', '새 블로그 작성 테스트', 'admin');

SELECT * FROM blogs;

INSERT INTO blogs (TITLE , CONTENT, AUTHOR)
VALUES ('테스트4', '작성 테스트', 'guest');

-- 글번호 2번 글의 제목과 내용을 수정하고 수정 날짜 컬럼을 시스템 현재 시간으로 업데이트
UPDATE blogs 
    SET title = '테스트2', content = '수정 테스트', modified_date = sysdate 
    WHERE blog_no = 2;

commit;













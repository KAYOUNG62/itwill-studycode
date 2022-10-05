/* 
 * SQL종류:
 * 1.DQL(Data Query Language): 데이터 질의 언어. select문.
 * 2.DDL(Data Definition Language): 데이터 정의 언어.
 *    - create, alter, truncate, drop
 *    - 테이블, 사용자 계정을 생성, 변경, 삭제하는 SQL문.
 * 3.DML(Data Manipulation Language): 데이터 조작 언어
 *   - insert, update, delete
 *   - 테이블에 행(row)을 추가, 변경, 삭제하는 SQL문장.
 * 4.TCL(Transaction Control Language): 트랜젝션 관리(제어) 언어.
 *   - commit(변경내용을 DB에 영구 저장), rollback(직전 commit까지 상태로 되돌리기)
*/ 

/*
 * 테이블 생성:
 * create table 테이블이름(
 *       컬럼이름  데이터타입  [제약조건, 기본값](생략가능),
 *       ...
 * );
*/

/* 테이블 이름: students
 * 컬럼이름/데이터타입: 
 *  - sid: 학생아이디. 숫자(number, 4자리정수)
 *  - sname: 학생이름. 문자열(varchar2, 10글자까지 저장 가능한 문자열)
 *  - birthday: 생일. 날짜(date).
*/

CREATE TABLE students (
    sid        number(4),
    sname      varchar2(10 char),
    birthday    date
);

-- DESCRIBE: 오라클만 가지고있는 비표준 명령어
DESCRIBE students; -- 생성된 테이블의 구조(컬럼, Null가능여부, 데이터타입) 확인.

/*
 * 테이블에 새로운 레코드(행 row)를 추가:
 * insert into 테이블 (컬럼, ... ) values(값, ...);
 * 
 * 테이블의 모든 컬럼에, 테이블 컬럼 순서대로 데이터를 추가하는 경우에는 컬럼 이름들을 생략할 수 있음.
 * insert into 테이블 values(값, ...)
 */
 
insert into students(sid,sname)
values (1001, '김가영');

SELECT * FROM students;

insert into students
values (1002, '김다훈', '2001/10/05');

insert into students values (1003, '오쌤');
--> 에러발생: 테이블의 컬럼 개수보다 적은 개수의 값을 전달했기 때문에.
insert into students values ('오쌤', 1003, '2022/10/05');
--> 에러발생: values의 순서에서 sid 위치에 숫자 타입이 아닌 문자열을 전달했기 때문에.

insert into students (sname, sid, birthday) 
values ('김상준', 1003, '2022/10/05');

-- DML(insert, update, delete)에서 변경 내용은 메모리에서만 변경됨.
-- commit: 데이터 변경 내용을 DB에 영구적으로 저장
commit;

-- DDL(create, alter, truncate, drop)은 문장 실행이 성공하면 자동으로 commit됨

-- students 테이블과 똑같은 구조의 테이블 students2를 생성.
-- create-as select 문장: 다른 테이블에서 select한 내용 그대로 새로운 테이블을 생성.
CREATE TABLE students2
AS SELECT * FROM students; --테이블 복사

SELECT * FROM students2;

-- create- as select 문장을 사용해서 데이터 복사 없이 새 테이블만 생성하는 경우
CREATE TABLE students3
AS SELECT * FROM students WHERE sid =-1;

SELECT * FROM students3;

-- 테이블을 생성할때, 컬럼의 기본값을 설정하기:
CREATE TABLE tbl_users (
    user_no     number(6),
    userid      varchar2(100), -- 20바이트까지 저장할 수 있는 문자열 
    password    varchar2(20),
    age         number(3) default 0, -- 기본값 0 
    modified_date   date default sysdate -- 기본값 현재 시간
);

SELECT * FROM tbl_users;

insert into tbl_users (user_no, userid, password)
values (1, 'admin', '1234');
-- insert문장에서 값을 삽입하지 않은 컬럽들 중에서 default가 설정되어있는 경우에는
-- 그 기본값이 자동으로 삽입됨.

insert into tbl_users (user_no, userid)
values (2, 'guest');

-- 변경내용 저장
commit;

-- 테이블 삭제:
-- truncate table: 테이블의 모든 레코드(행)이 삭제되고, 테이블 이름만 남아 있는 경우.
-- drop table: 테이블 자체가 삭제됨.
-- DML 중 delete from 테이블이름 : 테이블의 레코드들을 삭제. (commit과 rollback이 가능)

SELECT * FROM tbl_users;

delete from tbl_users where user_no = 1; --DML
truncate table tbl_users; -- DDL
drop table tbl_users; -- DDL
    
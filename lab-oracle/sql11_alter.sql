-- DDL(Data Definition Language): create, truncate, drop, alter
-- create user scott identified tiger;
-- alter user hr account unlock;
-- alter user hr identified by hr;
-- drop user scott; > scott 계정을 삭제

-- alter table 테이블이름 변경내용;
-- 변경내용: (1)이름 변경(rename), (2)추가(add), (3)삭제(drop), (4)수정(modify)

-- 이름 변경(rename):
-- (1)테이블 이름 변경: students 테이블의 이름을 students1로 변경
ALTER TABLE students RENAME to students1;

-- (2)컬럼 이름 변경: students1.sid 컬럼이름을 stu_id로 변경
ALTER TABLE students1 RENAME COLUMN sid TO stu_id;

-- (3)제약조건 이름 변경: ex01 테이블의 SYS_C007001 제약조건이름을 ex01_col1_pk로 변경
ALTER TABLE ex01 RENAME CONSTRAINT SYS_C007001 TO ex01_col1_pk;

-- 추가(add):
-- (1)새로운 컬럼 추가: students1 테이블에 department 컬럼(varchar2) 추가.
ALTER TABLE students1 ADD department varchar2(10);

-- (2)새로운 제약조건 추가: students1 테이블에 stu_id 컬럼에 PK 제약 조건 추가.
ALTER TABLE students1 ADD CONSTRAINT students1_stu_id_pk primary key (stu_id);

-- 삭제(drop) > alter 사용
-- (1)테이블의 컬럼을 삭제: students2 테이블의 birthday 컬럼 삭제.
ALTER TABLE students2 DROP COLUMN birthday;

-- (2)제약조건 삭제: students1 테이블의 students1_stu_id_pk 제약 조건 삭제 
ALTER TABLE students1 DROP CONSTRAINT students1_stu_id_pk;

-- 비교: 테이블 자체를 삭제 >DROP TABLE
DROP TABLE students3;

-- 수정(modify): 컬럼의 정의(데이터타입, null 가능 ->not null)를 수정.
-- 제약 조건의 정의를 수정하는 modify 구문은 제공되지 않음.
-- 제약 조건 수정: drop constraint -> add constraint

-- students1.department 컬럼의 데이터 타입을 varchar2(10 char)로 수정
ALTER TABLE students1 MODIFY department varchar2(10 char);
desc students1;



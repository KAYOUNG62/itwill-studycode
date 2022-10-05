-- 제약 조건(constraints)
-- 테이블에 데이터들이 insert될 때, 조건을 만족하는 값들만 insert될 수 있도록 만들어 주는 기능.
-- 테이블 생성(create table)할 때 제약 조건을 설정.
-- 테이블 변경(alter table) 할 때 제약 조건을 설정/변경/삭제. 
-- 제약 조건의 종류: primary key(고유키), not null, unique, check, foreign key(외래키)

-- 테이블 생성할 때 제약 조건을 주는 방법 1:
CREATE TABLE ex01 (
    col_1  number(2)     PRIMARY KEY,
    col_2  varchar2(10)  not null,
    col_3  varchar2(10)  unique,
    col_4  number(2)     check(col_4 >= 0),
    col_5  number(2)
);

INSERT INTO ex01 
VALUES (1, '홍길동', 'test', 10, 99);

SELECT * FROM ex01;

INSERT INTO ex01 (col_1, col_2)
VALUES (1, '홍길동');
--> 에러발생: col_1은 PK이기 때문에 중복되는 값을 insert할 수 없음.
-- primary key(고유키) = not null(반드시값이 필요) + unique(중복되지않는값)

INSERT INTO ex01 (col_2) VALUES ('홍길동');
--> 에러발생: col_1 은 PK이기 때문에 null이 될 수 없음!

INSERT INTO ex01 (col_1, col_2) VALUES (2);
--> 에러발생: col_2는 Not Null이기 때문에 NULL이 될 수 없음!

INSERT INTO ex01 (col_1, col_2, col_3) values (2, '홍길동', 'test');
--> 에러발생: col_3은 unique 제약조건인데, 기존에 입력된 값과 같은 'test'를 insert하려고 했기 때문에.

INSERT INTO ex01 (col_1, col_2) values (2, '홍길동');
--> 성공: PK, not null 만족 

INSERT INTO ex01 (col_1, col_2, col_4) values (3, '홍길동', -1);
--> 에러발생: col_4 >= 0 (check 제약조건) 이어야 하는데, -1을 insert 하려고 했기 때문에

INSERT INTO ex01 (col_1, col_2, col_4) values (3, '홍길동', 4);

commit;

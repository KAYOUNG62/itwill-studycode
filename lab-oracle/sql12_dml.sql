-- DML(Data Manipulation Language): insert, update, delete
 
-- insert 테이블이름 [(컬럼, ...)] values (값, ...);
-- update 테이블이름 set 컬럼 = 값, ... [where 조건식];
-- delete from 테이블이름 [where 조건식];

SELECT * FROM emp;

-- 사번이 1004인 직원의 급여를 5000으로 업데이트
UPDATE emp SET sal = 5000; -- 테이블의 모든 행의 sal 값을 업데이트.
ROLLBACK;

UPDATE emp SET sal = 5000 WHERE empno = 1004;

-- 사번 1004인 직원의 직무는 'SALESMAN', 입사날짜는 '2022/10/06'로 업데이트
UPDATE emp SET job = 'SALEAMAN', hiredate = to_date('2022/10/06', 'YYYY/MM/DD') WHERE empno = 1004;

-- emp 테이블에서 'ACCOUNTING' 부서에서 일하는 직원들의 급여를 10% 인상
UPDATE emp 
SET sal = sal * 1.1  -- sal = sal + sal * 0.1
WHERE deptno = (
    SELECT deptno 
    FROM dept 
    WHERE dname = 'ACCOUNTING'
);

commit;

DELETE from emp; -- 조건절(where)이 없으면 테이블의 모든 행을 삭제.
ROLLBACK; -- delete는 rollback이 가능한 DML. truncate table은 rollback이 불가능한 DDL

-- 사번이 1004인 직원의 레코드(행)을 삭제.
DELETE from emp WHERE empno = 1004;

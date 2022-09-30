-- 테이블에서 데이터 검색
-- (1) projection: 테이블에서 원하는 컬럼들을 선택. (9.29 수업 내용)
-- (2) selection: 테이블에서 조건을 만족하는 레코드(행, row)들을 검색.
-- select 컬럼, ... from 테이블 where 조건식 (order by 정렬컬럼 asc/ desc);
-- 비교 연산자: =, !=, >, >=, < , <= < , is null, is not null, ... 
-- 논리 연산자: and, or, not, ... 

-- 직원 테이블에서 10번 부서에 근무하는 직원들의 부서번호, 사번, 이름을 검색
SELECT deptno, empno, ename 
FROM emp 
WHERE deptno = 10;

-- 직원 테이블에서 수당(comm)dl null이 아닌 직원들의 사번, 이름, 수당을 검색.
-- 출력 순서는 이름의 오름차순으로 정렬
SELECT empno, ename, comm 
FROM emp 
WHERE comm is not null;

-- 직원 테이블에서 급여(sal)가 2000 이상인 직원들의 이름과 급여를 검색.
-- 출력 순서는 급여의 내림차순 정렬
SELECT ename, sal 
FROM emp 
WHERE sal >= 2000 
ORDER BY sal desc;

-- 직원 테이블에서 급여가 2000이상 3000이하인 직원들의 사번, 이름, 직책, 급여를 검색
-- 급여의 내림차순 출력 
SELECT empno, ename, job, sal 
FROM emp 
WHERE sal >= 2000 AND sal <= 3000
ORDER BY sal DESC;

SELECT empno, ename, job, sal
FROM emp
WHERE sal BETWEEN 2000 AND 3000
ORDER BY sal DESC;

-- 직원 테이블에서 10번 또는 20번 부서에서 근무하는 직원들의 부서번호, 이름, 급여를 검색
-- 출력 순서는 (1)부서번호, (2)이름 오름차순 정렬
SELECT deptno, ename, sal
FROM emp
WHERE deptno = 10 OR deptno = 20
ORDER BY deptno, ename;

SELECT deptno, ename, sal
FROM emp
WHERE deptno in (10, 20) -- in (비교값 나열)
ORDER BY deptno, ename;

-- 직원 테이블에서 직무가 'CLERK'인 직원들의 직무, 이름, 급여를 출력
-- 이름 오름차순으로 출력
SELECT job, ename, sal
FROM emp
WHERE job = 'CLERK'
ORDER BY ename;
-- SQL에서는 문자열 비교에서도 =, !=를 사용.
-- 테이블에 저장된 데이터는 대/소문자를 구분. SQL명령어는 대/소문자를 구분하지 않음.
-- 문자열은 작은따옴표('')를 사용. 

-- 직원 테이블에서 직무가 CLERK 또는 MANAGER인 직원들의 직무, 이름, 급여를 검색.
-- 출력 순서 (1)직무, (2)급여 오름차순 정렬
SELECT job, ename, sal
FROM emp
WHERE job in ('CLERK', 'MANAGER')
ORDER BY job, sal;

SELECT job, ename, sal
FROM emp
WHERE job = 'CLERK' OR job = 'MANAGER'
ORDER BY job, sal;

-- 직원 테이블에서 20번 부서에서 근무하는 CLERK의 모든 정보를 검색 
SELECT *
FROM emp
WHERE job = 'CLERK' AND deptno = 20;

-- 직원 테이블에서 20번 부서에서 근무하거나 또는 직무가 CLERK인 직원들의 모든 정보를 검색
SELECT *
FROM emp
WHERE job = 'CLERK' OR deptno = 20;

-- 직원 테이블에서 CLERK, ANALYST, MANAGER가 아닌 직원들의 사번, 이름, 직무, 급여를 검색
-- 사번 오름차순 정렬 
SELECT empno, ename, job, sal
FROM emp
WHERE job != 'CLERK' AND job != 'ANALYST' AND job != 'MANAGER'
ORDER BY empno;

SELECT empno, ename, job, sal
FROM emp
WHERE not (job = 'CLERK' OR job = 'ANALYST' OR job = 'MANAGER')
ORDER BY empno;

SELECT empno, ename, job, sal
FROM emp
WHERE job not in ('CLERK','ANALYST','MANAGER')
ORDER BY empno;

-- 직원 테이블의 모든 레코드를 입사일의 오름차순으로 출력
SELECT *
FROM emp
ORDER BY hiredate;

-- 숫자뿐만 아니라 문자열(varchar2), 날짜(date, timestamp) 타입들도 대소 비교가 가능.
-- 1987/01/01을 포함해서 그 이후에 입사한 사원들의 레코드(모든 컬럼)을 검색
-- 입사일 오름차순
SELECT *
FROM emp
WHERE hiredate >= '1987/01/01' -- 문자열 타입과 날짜 타입을 같은 타입으로 변환 후에 대소 비교가 이루어짐
ORDER BY hiredate;

-- 특정 문자열로 시작하거나, 특정 문자열이 포함된 값을 값는 query.
-- A로 시작하는 이름을 갖는 직원들의 이름을 오름차순으로 출력
SELECT ename
FROM emp
WHERE ename LIKE 'A%'-- A로 시작하고, 그 뒤에는 글자수제한 없이 어떤글자가 와도 상관없음.
ORDER BY ename;

SELECT ename
FROM emp
WHERE ename LIKE 'A_'; -- A로 시작하고, 그 뒤에 한글자만 더 있는 문자열.

-- '%A': A로 끝나는 문자
-- '%A%': A가 포함되어있는 문자

-- 30번 부서에서 근무하는 직무가 'SALES' 로 시작하는 직원들의 사번, 이름, 급여, 부서번호, 직무를 검색
-- 사번 오름차순으로 정렬
SELECT empno, ename, sal, deptno, job
FROM emp
WHERE deptno = 30 AND job LIKE 'SALES%'
ORDER BY empno;

-- 20번 또는 30번 부서에서 근무하고 급여가 2000을 초과하는 직원들의 사번, 부서번호, 이름, 급여를 검색
-- (1)부서번호, (2)사번 오름차순으로 정렬
SELECT empno, deptno, ename, sal
FROM emp
WHERE deptno in (20,30) AND sal > 2000
-- where (deptno = 20 or deptno = 30 ) and sal > 2000
ORDER BY deptno, empno;

-- 수당이 null이고, 매니저가 있고, 직무가 'MANAGER' 또는 'CLERK'인 직원들의 
-- 모든 컬럼을 검색, 사번 오름차순 출력
SELECT *
FROM emp
WHERE comm is null 
    AND mgr is not null 
    AND job in ('CLERK','MANAGER')
    -- and (job = 'CLERK' or job = 'MANAGER')
ORDER BY empno;

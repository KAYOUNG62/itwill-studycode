 -- Sub Query: query문의 일부로 또다른 query문이 사용되는것.
 
 -- 전체 직원의 급여 평균보다 더 많은 급여를 받는 직원들의 레코드(모든 정보)를 검색
 -- (1)전체 직원의 급여 평균 검색 
SELECT avg(sal) FROM emp;
 -- (2) 1에서 찾은 급여 평균보다 더 많은 급여를 받는 직원을 검색 
SELECT xla
FROM emp
WHERE sal > 2073;
-- 위의 1, 2 를 한 문장으로 --> Sub Query
SELECT * FROM emp
WHERE sal > ( SELECT avg(sal) FROM emp);

-- Ex. ALLEN보다 적은 급여를 받는 직원들의 사번, 이름, 급여를 검색
SELECT empno, ename, sal 
FROM emp
WHERE sal < (
    SELECT sal FROM emp WHERE ename = 'ALLEN'
);

-- Ex. ALLEN과 같은 직책의 직원들의 사번, 이름, 부서번호, 직책, 급여를 검색
SELECT empno, ename, deptno, job, sal
FROM emp
WHERE job = (
    SELECT job FROM emp WHERE ename = 'ALLEN'
);

-- Ex. SALESMAN의 급여 최댓값보다 더 많은 급여를 받는 직원들의 사번, 이름, 급여, 직책을 검색
SELECT empno, ename, sal, job
FROM emp
WHERE sal > (
    SELECT max(sal) FROM emp WHERE job = 'SALESMAN'
);

-- Ex. 연봉 = sal * 12 + comm. 만약 comm이 null이면 0으로 계산.
-- WARD의 연봉보다 더 많은 연봉을 받는 직원들의 사번, 이름, 급여, 수당, 연봉을 검색.
-- 연봉 내림차순으로 출력. 
-- nvl2(comm, comm, 0) > nvl2(컬럼, null이 아닐때 리턴값, null일때 리턴값)
SELECT empno, ename, sal, comm, 
    sal * 12 + nvl(comm, 0) as "ANNUAL_SAL"
FROM emp
WHERE (sal * 12 + nvl(comm, 0)) > (
    SELECT sal *12 + nvl(comm, 0) 
    FROM emp 
    WHERE ename = 'WARD'
)
ORDER BY ANNUAL_SAL DESC;

-- EX. SCOTT과 같은 급여를 받는 직원(들)의 이름과 급여를 검색
SELECT ename, sal
FROM emp
WHERE sal = (SELECT sal FROM emp WHERE ename = 'SCOTT');

-- EX. 위 결과에서 SCOTT은 제외하고 검색
SELECT ename, sal
FROM emp
WHERE sal = (
    SELECT sal FROM emp WHERE ename = 'SCOTT') 
    AND ename != 'SCOTT';

-- EX. ALLEN보다 늦게 입사한 직원(들)의 이름, 입사날짜를 최근 입사일부터 출력
SELECT ename, to_char(hiredate, 'YYYY/MM/DD') as "HIREDATE"
FROM emp
WHERE hiredate > (
    SELECT hiredate FROM emp WHERE ename = 'ALLEN')
ORDER BY hiredate desc;

-- EX. 매니저가 KING인 직원(들)의 사번, 이름, 매니저사번을 검색
-- 매니저 사번이 KING의 사번과 일치하는 레코드를 검색
SELECT empno, ename, mgr
FROM emp
WHERE mgr = (
    SELECT empno FROM emp WHERE ename = 'KING');
    
-- EX. DALLAS에서 근무하는 직원들의 이름과 급여, 부서번호를 검색.
SELECT ename, sal, deptno
FROM emp
WHERE deptno = (
    SELECT deptno FROM dept where loc = 'DALLAS');

-- 단일행 서브쿼리: 서브쿼리의 결과가 행이 1개 이하인 경우.
-- 다중행 서브쿼리: 서브쿼리의 결과가 2개 이상의 행인 경우.
-- (주의) 다중행 서브쿼리에서는 한 개의 값과 단순비교(=, !=, >, <,...)를 할 수 없음.
--        in, any, all과 같은 키워드를 함께 사용해야함. 

-- 각 부서에서 급여를 가장 많이 받는 직원들의 모든 정보를 검색.
SELECT deptno, max(sal)
FROM emp
GROUP BY deptno;

SELECT *
FROM emp
WHERE (deptno, sal) in (
    SELECT deptno, max(sal)
    FROM emp
    GROUP BY deptno
);

-- 각 부서에서 급여가 최소인 직원들의 모든 정보를 검색
SELECT *
FROM emp
WHERE (deptno, sal) in (
    SELECT deptno, min(sal)
    FROM emp
    GROUP BY deptno)
ORDER BY deptno;

-- 다중행 서스쿼리에서 any와 all
--  any: 여러개들 중에서 적어도 하나
--  all: 여러개 모두.
SELECT *
FROM emp
WHERE sal < ALL(
    SELECT sal FROM emp WHERE deptno = 10);
-- 위의 all을 사용한 서브쿼리와 같은 결과를 주는 쿼리
SELECT *
FROM emp
WHERE sal < (SELECT min(sal) FROM emp WHERE deptno = 10);

SELECT * 
FROM emp
WHERE sal <any (
    SELECT sal FROM emp WHERE deptno = 10);
    
-- any를 사용하는 위의 결과와 같은 결과를 주는 쿼리
SELECT *
FROM emp
WHERE sal < (
    SELECT max(sal) FROM emp WHERE deptno=10);
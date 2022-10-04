-- 오라클 함수(function)
-- (1) 단일 행 함수:
--      행(row)이 하나씩 함수의 argument로 전달되고, 행 마다 하나씩 결과가 리턴되는 함수. 
-- (2) 다중 행 함수(그룹함수):
--      여러개의 행(row)이 한꺼번에 함수의 argument로 전달되서, 하나의 결과가 리턴되는 함수.
--      (예) 통계 관련 함수들: count, sum, avg, max, min, variance(분산), stddev(표준편차)
-- 단일 행 함수와 그룹 함수는 동시에 select 할 수 없음

-- 단일 행 함수의 예
-- 문자열을 소문자로 바꾸기
SELECT lower(ename) FROM emp;

-- 날짜 타입 데이터를 원하는 문자열 포멧으로 출력.
SELECT hiredate, to_char(hiredate, 'YYYY-MM-DD')
FROM emp;

-- nvl(컬럼, value): 컬럼의 값이 null이면 value를 리턴, null 이 아니면 원래 값을 리턴
-- nvl2(컬럼이름, value1, value2): 컬럼이 null이 아니면 value1을 리턴, null 이면 value2를 리턴.
SELECT comm, nvl(comm, -1), nvl2(comm, comm, -1)
FROM emp;

-- 다중행 함수(그룹함수)
-- count(컬럼): null이 아닌 행의 개수를 리턴.
SELECT count(empno),count(mgr),count(comm) FROM emp;

SELECT count(*) FROM emp; -- 테이블의 행 개수

-- 통계 함수: 합계, 평균, 최대값, 최소값, 분산, 표준편차
SELECT sum(sal), avg(sal), max(sal), min(sal), VARIANCE(sal), STDDEV(sal)
FROM emp;

-- 그룹별 통계
-- 부서(번호)별 급여의 최대값
SELECT max(sal) FROM emp WHERE deptno = 10;
SELECT max(sal) FROM emp WHERE deptno = 20;
SELECT max(sal) FROM emp WHERE deptno = 30;

SELECT deptno, max(sal)
FROM emp
GROUP BY deptno
ORDER BY deptno;

SELECT deptno, round(avg(sal),2)
FROM emp
GROUP BY deptno
ORDER BY deptno;
-- round(함수, 소수점자리수)

-- 아래의 모든 문제에서 소수점은 반올림해서 2자리까지 표시
-- Ex. 부서별 급여의 평균, 표준편차를 출력, 부서번호 오름차순 정렬
SELECT deptno, round(avg(sal) ,2) as "AVG", round(stddev(sal),2) as "STDDEV"
FROM emp
GROUP BY deptno
ORDER BY deptno;

-- Ex. 직무별 직원수, 급여의 최댓값, 최솟값, 평균 검색.
-- 직무 오름차순 정렬
SELECT job, count(job), max(sal), min(sal), round(avg(sal),2)
FROM emp
GROUP BY job
ORDER BY job;

-- Ex. 부서별, 직무별 부서번호, 직무, 직원수, 급여 평균 검색
-- 정렬순서는 (1)부서 번호 (2)직책 오름차순
SELECT deptno, job, COUNT(*), avg(sal)
FROM emp
GROUP BY deptno, job
ORDER BY deptno, job;

-- Ex. 입사연도별 사원수 검색. (힌트) to_char(날짜, 포맷) 이용.
SELECT to_char(hiredate, 'YYYY') as "YEAR", count(*)
FROM emp
GROUP BY to_char(hiredate, 'YYYY')
ORDER BY year;
-- select 절에서 만든 별명(alias)는 where, group by, having 절에서는 사용할 수 없고,
-- order by 에서 사용 가능.

/* select 문장의 순서:
 * select 컬럼, ...
 * from 테이블
 * where (그룹을 묶기 전에 검사할) 조건식
 * group by 그룹을 묶어줄 컬럼 이름, ...
 * having 그룹을 묶은 다음에 검사할 조건식
 * order by 출력 순서를 결정할 컬럼, ...;
 */
 
 -- 부서별 부서번호, 급여 평균 검색.
 -- 부서별 급여 평균이 2000이상인 부서들만 출력
 -- 부서 번호의 오름차순
 SELECT deptno, round(avg(sal) ,2)
FROM emp
GROUP BY deptno
HAVING round(avg(sal) ,2) >= 2000
ORDER BY deptno;

-- Ex. emp 테이블에서 mgr가 null이 아닌 직원들 중에서
-- 부서별 급여 평균을 검색. 부서 번호 오름차순 출력.
SELECT deptno, round(avg(sal),2) as "AVG_SAL"
FROM emp
WHERE mgr is not null
GROUP BY deptno
ORDER BY deptno;

-- Ex. 직책별 사원수를 검색.
-- 직책이 PRESIDENT는 제외.
-- 직책별 사원수가 3명 이상인 경우만 선택.
-- 직책 오름차순 출력. 
SELECT job, count(job) as "count"
FROM emp
WHERE job != 'PRESIDENT'
GROUP BY job
HAVING count(job) >= 3 -- select에서 설정한 별명을 having에서 사용할 수 없음.
-- HAVING job != 'PRESIDENT' AND count(job) >= 3
ORDER BY job;

-- Ex. 입사연도, 부서 번호, 입사연도별 부서별 입사한 사원수 검색.
-- 1980년 제외.
-- 연도별 부서별 사원수가 2명 이상인 경우 선택.
-- 연도 오름차순 출력.
SELECT to_char(hiredate, 'YYYY') as "YEAR" , deptno, count(*)
FROM emp
WHERE to_char(hiredate, 'YYYY') != '1980'
GROUP BY to_char(hiredate, 'YYYY') , deptno
HAVING count(*) >= 2 
ORDER BY YEAR;

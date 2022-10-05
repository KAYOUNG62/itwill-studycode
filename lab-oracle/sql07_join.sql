/*  
조인(join): 2개 이상의 테이블에서 검색하는 것.

join 문법:
1) ANSI 표준 문법:
    select 컬럼, ...
    from 테이블 1 join종류 테이블2 on join조건;
2) Oracle 문법:
    select 칼럼, ...
    from 테이블1, 테이블2...
    where join 조건;

join 종류: 
1) inner join
2) outer join
    (1) left outer join
    (2) right outer join
    (3) full outer join
join 종류를 말할 때 inner, outer는 생략 가능. 
*/

-- 사번, 이름, 부서번호, 부서이름 검색 - inner join
-- inner join은 두 테이블(emp, dept)에서 공통으로 등장하는 부서번호(10,20,30)을 검색.
-- 1)ANSI 표준
SELECT emp.empno, emp.ename, emp.deptno, dept.dname
FROM emp
    inner join dept on emp.deptno = dept.deptno;

-- 2) Oracle 문법
SELECT emp.empno, emp.ename, emp.deptno, dept.dname
FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- left/right/full outer join의 차이점:
-- emp 테이블에 values의 내용을 저장(insert into)
INSERT INTO emp(empno,ename,deptno)
VALUES (1004, '오쌤', 50);

commit; -- 테이블 변경 내용을 영구 저장.

-- 사번, 이름, 부서번호, 부서이름 -left outer join
-- 왼쪽 테이블에서 등장하는 모든부서번호(10,20,30,50)가 검색.
-- select에서 부서번호
-- 1)ANSI 표준
SELECT e.empno, e.ename, e.deptno, d.deptno, d.dname
FROM emp e
    left outer join dept d on e.deptno = d.deptno;

-- 2) Oracle 문법
SELECT e.empno, e.ename, e.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno(+);

-- 사번, 이름, 부서번호, 부서이름 - right outer join
-- 1)ANSI 표준
SELECT e.empno, e.ename, e.deptno, d.deptno, d.dname
FROM emp e right outer join dept d 
    on e.deptno = d.deptno;

-- 2) Oracle 문법
SELECT e.empno, e.ename, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno; 

-- 사번, 이름, 부서번호, 부서이름 - full outer join
-- 1)ANSI 표준
SELECT e.empno, e.ename, e.deptno, d.deptno, d.dname
FROM emp e FULL OUTER JOIN dept d
    ON e.deptno = d.deptno;
    
-- 2) Oracle 문법 : full outer join의 문법을 제공하지 않음. 합집합 연산을 이용할 수 있음.
SELECT e.empno, e.ename, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno(+)
UNION -- 합집합
SELECT e.empno, e.ename, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;

-- 사번, 부서이름(null이 아닌), 이름, 급여를 검색 (inner join)
-- 급여가 2000이상인 직원들을 검색 출력 순서는 급여의 내림차순
-- ANSI 표준
SELECT e.empno, d.dname, e.ename, e.sal
FROM emp e join dept d
    on e.deptno = d.deptno
WHERE e.sal >= 2000
ORDER BY sal DESC;

-- Oracle  
SELECT e.empno, d.dname, e.ename, e.sal
FROM emp e, dept d
WHERE e.deptno = d.deptno AND e.sal >= 2000
ORDER BY sal DESC;

-- self-join: 같은 테이블에서 join을 하는 것.
-- 사번, 이름, 매니저사번, 매니저이름을 검색
SELECT e1.empno, e1.ename as "직원이름", e1.mgr, e2.ename as "매니저이름"
FROM emp e1 join emp e2 
    on e1.mgr = e2.empno;

SELECT e1.empno, e1.ename, e1.mgr, e2.ename
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno;

-- 위의 inner join 결과와 left/right/full outer join의 결과를 비교
SELECT  e1.empno, e1.ename as "직원이름", e1.mgr, e2.ename as "매니저이름"
FROM emp e1 LEFT JOIN emp e2 
    ON e1.mgr = e2.empno;

SELECT  e1.empno, e1.ename as "직원이름", e1.mgr, e2.ename as "매니저이름"
FROM emp e1 full JOIN emp e2 
    ON e1.mgr = e2.empno;

-- Non-equi join: join의 조건식이 부등식(>, >=, <, <= ...) 이 되는 경우
-- 사번, 이름,급여, 급여등급을 검색
SELECT e.empno, e.ename, e.sal, s.grade
FROM emp e JOIN salgrade s 
    ON e.sal BETWEEN s.losal AND s.hisal;


SELECT e.empno, e.ename, e.sal, s.grade
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal;
--WHERE e.sal BETWEEN s.losal(+) AND s.hisal(+); > left join

--부서이름, 부서위치, 부서의 직원수를 검색 (inner join)
SELECT count(*), deptno
FROM emp
GROUP BY emp.deptno;
-- 1)ANSI:
SELECT d.dname, d.loc, count(*)
FROM dept d JOIN emp e
    ON d.deptno = e.deptno
GROUP BY d.dname, d.loc;

-- 2)Oracle
SELECT d.dname, d.loc, count(*)
FROM dept d, emp e
WHERE d.deptno = e.deptno
GROUP BY d.dname, d.loc;

-- 부서번호, 부서이름, 부서의 사원수, 부서의 급여 최소값, 급여 최대값을 검색
SELECT d.deptno, d.dname, count(*), max(sal), min(sal)
FROM dept d JOIN emp e 
    ON d.deptno = e.deptno
GROUP BY d.deptno, d.dname;

SELECT d.deptno, d.dname, count(*), max(sal), min(sal)
FROM dept d, emp e
WHERE d.deptno = e.deptno
GROUP BY d.deptno, d.dname;

-- 3개의 테이블을 join
-- 급여가 3000이상인 직원이름, 부서위치, 급여, 등급을 검색. 
SELECT e.ename, d.loc, e.sal, s.grade
FROM emp e 
    JOIN dept d ON d.deptno = e.deptno
    JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal
WHERE e.sal >= 3000;

SELECT e.ename, d.loc, e.sal, s.grade
FROM emp e, dept d, salgrade s
WHERE d.deptno = e.deptno
    AND e.sal BETWEEN s.losal AND s.hisal
    AND e.sal >= 3000;

-- dept emp1 emp2, salgrade
-- 부서번호, 부서이름, 사번, 이름, 매니저사번, 매니저이름, 급여, 급여등급을 검색
-- 부서번호 오름차순, 사번 오름차순
SELECT e1.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e2.ename, e1.sal, s.grade
FROM emp e1 
    JOIN emp e2 ON e1.mgr = e2.empno
    JOIN dept d ON e1.deptno = d.deptno
    JOIN salgrade s ON e1.sal BETWEEN s.losal AND s.hisal
ORDER BY e1.deptno, e1.empno;

SELECT e1.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e2.ename as "매니저 이름",
    e1.sal, s.grade
FROM emp e1, emp e2, dept d, salgrade s
WHERE e1.mgr = e2.empno
    AND e1.deptno = d.deptno
    AND e1.sal BETWEEN s.losal AND s.hisal
ORDER BY e1.deptno, e1.empno;


-- HR 계정의 테이블을 사용한 GROUP BY, JOIN, SUB QUERY 연습

-- 1. 직원의 last_name과 부서 이름을 검색.
SELECT e.last_name, d.department_name
FROM employees e 
    JOIN departments d ON e.department_id = d.department_id;

-- 2. 직원의 last_name과 부서 이름을 검색. 부서 번호가 없는 직원도 출력. (left join)
SELECT e.last_name, d.department_name
FROM employees e left JOIN departments d
    ON e.department_id = d.department_id;

-- 3. 직원의 last_name과 직무(job title)을 검색.
SELECT e.last_name, j.job_title
FROM employees e 
    join jobs j ON e.job_id = j.job_id;
    
-- 4. 직원의 last_name과 직원이 근무하는 도시 이름(city)를 검색
SELECT e.last_name , l.city
FROM  departments d
    JOIN employees e ON e.department_id = d.department_id
    JOIN locations l ON d.location_id = l.location_id;
 
-- 5. 직원의 last_name과 직원이 근무하는 도시 이름(city)를 검색. 근무 도시를 알 수 없는 직원도 출력.
SELECT e.last_name , l.city
FROM  departments d
    LEFT JOIN employees e ON e.department_id = d.department_id
    LEFT JOIN locations l ON d.location_id = l.location_id;

-- 6. 2008년에 입사한 직원들의 last_name을 검색.
SELECT last_name, to_char(hire_date, 'YYYY') as "HIRE_DATE"
FROM employees
WHERE to_char(hire_date, 'YYYY') = '2008';
-- to_char(날짜, 포맷): 날짜 타입을 포맷 형식의 문자열로 변환해서 리턴.

SELECT last_name, hire_date
FROM employees
WHERE hire_date BETWEEN TO_DATE('2008/01/01', 'YYYY/MM/DD') AND TO_DATE('2008/12/31', 'YYYY/MM/DD');
--to_date(문자열, 포맷): 문자열을 date 타입으로 변환해서 리턴

-- 7. 2008년에 입사한 직원들의 부서 이름과 부서별 인원수 검색.
SELECT to_char(hire_date, 'YYYY') as "HIRE_DATE", d.department_name, count(*)
FROM employees e JOIN departments d
    ON e.department_id = d.department_id
WHERE to_char(hire_date, 'YYYY') = '2008'
GROUP BY d.department_name, to_char(hire_date, 'YYYY');

-- 8. 2008년에 입사한 직원들의 부서 이름과 부서별 인원수 검색. 
--    단, 부서별 인원수가 5명 이상인 경우만 출력.
SELECT to_char(hire_date, 'YYYY') as "HIRE_DATE", d.department_name, count(*)
FROM employees e JOIN departments d
    ON e.department_id = d.department_id
WHERE to_char(hire_date, 'YYYY') = '2008' 
GROUP BY d.department_name, to_char(hire_date, 'YYYY') 
HAVING count(*) >= 5;

-- 9. 부서번호, 부서별 급여 평균을 검색. 소숫점 한자리까지 반올림 출력.
SELECT department_id, round(avg(salary),1) as "AVG_SALARY"
FROM employees
GROUP BY department_id;

-- 10. 부서별 급여 평균이 최대인 부서의 부서번호, 급여 평균을 검색.
--1)
SELECT department_id, round(avg(salary),1) as "AVG_SALARY"
FROM employees
GROUP BY department_id
HAVING round(avg(salary),1) in (
    SELECT max(round(avg(salary),1))
    FROM employees
    GROUP BY department_id);

--2)
SELECT department_id, avg(salary)
FROM employees
GROUP BY department_id
HAVING avg(salary) = (
    select max(avg(salary))
    from employees
    group by department_id);


--with as select 구문
with t as (
    SELECT department_id, avg(salary) as AVG_SAL
    FROM employees
    GROUP BY department_id)
SELECT department_id, round(AVG_SAL,1)
FROM t
WHERE AVG_SAL = (
    select max(AVG_SAL) from t
);

-- 11. 사번, 직원이름, 국가이름, 급여 검색.
SELECT e.employee_id, first_name || ' ' || last_name as "EMP_NAME" , c.country_name, e.salary
FROM  departments d 
    JOIN employees e ON e.department_id = d.department_id
    JOIN locations l ON d.location_id = l.location_id
    JOIN countries c ON l.country_id = c.country_id;

-- 12. 국가이름, 국가별 급여 합계 검색
SELECT c.country_name, sum(salary)
FROM  departments d 
    JOIN employees e ON e.department_id = d.department_id
    JOIN locations l ON d.location_id = l.location_id
    JOIN countries c ON l.country_id = c.country_id
GROUP BY c.country_name;
    
-- 13. 사번, 직원이름, 직책이름, 급여를 검색.
SELECT e.employee_id, first_name || ' ' || last_name as "EMP_NAME", j.job_title, e.salary
FROM employees e 
    JOIN jobs j ON e.job_id = j.job_id;

-- 14. 직책이름, 직책별 급여 평균, 최솟값, 최댓값 검색.
SELECT j.job_title, avg(salary), min(salary), max(salary)
FROM employees e 
    JOIN jobs j ON e.job_id = j.job_id
GROUP BY j.job_title;

-- 15. 국가이름, 직책이름, 국가별 직책별 급여 평균 검색.
SELECT c.country_name, j.job_title, round(avg(salary) ,2) as "AVG_SALARY"
FROM employees e
    JOIN jobs j ON e.job_id = j.job_id
    JOIN departments d ON e.department_id = d.department_id
    JOIN locations l ON d.location_id = l.location_id
    JOIN countries c ON l.country_id = c.country_id
GROUP BY c.country_name, j.job_title
ORDER BY c.country_name, j.job_title;

-- 16. 국가이름, 직책이름, 국가별 직책별 급여 합계를 출력.
--     미국에서, 국가별 직책별 급여 합계가 50,000 이상인 레코드만 출력.
SELECT c.country_name, j.job_title, sum(salary)
FROM employees e
    JOIN jobs j ON e.job_id = j.job_id
    JOIN departments d ON e.department_id = d.department_id
    JOIN locations l ON d.location_id = l.location_id
    JOIN countries c ON l.country_id = c.country_id
WHERE c.country_name = 'United States of America'
GROUP BY c.country_name, j.job_title
HAVING sum(salary) >= 50000
ORDER BY c.country_name, j.job_title;

 
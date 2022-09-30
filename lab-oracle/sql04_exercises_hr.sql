-- hr 계정의 employees 테이블 사용
-- 직원 이름을 출력할 때는 First/Last Name을 이어서 출력할 수 있도록(|| 연산자 사용)

-- Ex 1. employees 테이블의 구조(컬럼 이름, NULL 여부, 데이터 타입) 확인
SELECT *
FROM employees;

-- Ex 2. 성(last_name)이 'J'로 시작하는 직원들의 사번, 이름을 출력
SELECT employee_id , first_name ||' '|| last_name as "EMP_NAME"
FROM employees
where last_name LIKE 'J%';

-- Ex 3. 성(last_name)에 'E' 또는 'e'가 포함된 직원들의 사번, 이름을 출력
-- 오라클 문자열 함수 upper(컬럼), lower(컬럼)
SELECT employee_id , first_name ||' '|| last_name as "EMP_NAME"
FROM employees
where last_name LIKE '%E%' OR last_name LIKE '%e%';
-- where last_name in ('%E%','%e%'); > last_name = '%E%' OR last_name ='%e%' 이랑 같은 뜻.

SELECT employee_id , first_name ||' '|| last_name as "EMP_NAME"
FROM employees
where upper(last_name) like '%E%'; 
--  where lower(last_name) like '%e%' 로 대체 가능.


-- Ex 4. 전화번호가 '011'로 시작하는 직원들의 사번, 이름, 전화번호를 출력
SELECT employee_id , first_name ||' '|| last_name as "EMP_NAME", phone_number
FROM employees
where phone_number LIKE '011%';


-- Ex 5. 급여가 3000 이상 5000 이하인 직원들의 사번, 이름, 급여를 검색
-- 급여의 내림차순 출력
SELECT employee_id , first_name ||' '|| last_name as "EMP_NAME", salary
FROM employees
where salary BETWEEN 3000 AND 5000 
-- where salary >= 3000 and salary <=5000
ORDER BY salary desc;


-- Ex 6. 수당이 있는(not null) 직원들의 사번, 이름, 급여, 연봉을 검색
-- commission_pct 컬럼: 수당의 퍼센티지(percentage). 수당이 12개월 급여의 몇 %인 지.
-- 수당 포함 연봉 = 월급 * 12 + 특별 수당
--                = 월급 * 12 + (월급 * 12) * percentage
--                = (월급 * 12) * (1 + percentage)
SELECT employee_id , first_name ||' '|| last_name as "EMP_NAME", 
    salary ,(salary * 12) * (1 + commission_pct) as "ANNUAL_SALARY"
FROM employees
where commission_pct is not null;
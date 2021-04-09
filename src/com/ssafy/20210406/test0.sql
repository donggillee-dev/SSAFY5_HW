-- ※ Database Connections에 다음과 같이 셋팅
-- URL: ssafyweb
-- Database: jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8
-- 계정: ssafy 
-- 비밀번호: ssafy
-- -------------------------------------------------------------
-- 콘솔에서 사용자 계정으로 로그인(예: ssafy / ssafy)
-- [형식]
-- mysql -u 계정명 -p [데이터베이스명]
-- 비밀번호 입력

-- C:\Program Files\MySQL\MySQL Server 8.0\bin>mysql -u ssafy -p
-- Enter password: *****
-- mysql>
-- mysql> show databases;
-- +--------------------+
-- | Database           |
-- +--------------------+
-- | information_schema |
-- | mydb               |
-- | mysql              |
-- | performance_schema |
-- | sakila             |
-- | ssafydb            |
-- | ssafyweb           |
-- | sys                |
-- | world              |
-- +--------------------+
-- 9 rows in set (0.00 sec)

-- mysql> use ssafydb;
-- Database changed
-- mysql> show tables;
-- +-------------------+
-- | Tables_in_ssafydb |
-- +-------------------+
-- | countries         |
-- | departments       |
-- | employees         |
-- | job_history       |
-- | jobs              |
-- | locations         |
-- | regions           |
-- | salgrades         |
-- +-------------------+
-- 9 rows in set (0.02 sec)

-- mysql>
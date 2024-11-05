create database if not exists student_management;

use student_management;

set names utf8mb4;

drop table if exists sc;
drop table if exists course;
drop table if exists student;

-- 创建Student表 存储学生信息
create table student
(
    Sno   varchar(20) primary key, -- 学号
    Sname varchar(20) unique,      -- 姓名
    Ssex  varchar(2),              -- 性别
    Sage  smallint,                -- 年龄
    Sdept varchar(20)              -- 专业
)CHAR SET utf8;

-- 插入学生信息
INSERT INTO Student
(Sno, Sname, Sage, Ssex, Sdept)
VALUES ('20241127', '殷郊', 22, '男', '数学系'),
       ('20241128', '姬发', 20, '男', '数学系'),
       ('20241129', '苏妲己', 18, '女', '外语系'),
       ('20241201', '崇应彪', 23, '男', '体育系'),
       ('20241202', '小白', 20, '男', '计算机系'),
       ('20241203', '小黑', 21, '女', '外语系'),
       ('20241204', '小故', 19, '女', '外语系'),
       ('20241205', '小满', 22, '男', '数学系'),
       ('20241206', '嘻嘻', 20, '男', '计算机系'),
       ('20241207', '太阳', 21, '男', '计算机系'),
       ('20241208', '图图', 19, '女', '外语系');

-- 创建Course表 存储课程信息
create table course
(
    Cno     varchar(20) primary key,           -- 课程号
    Cname   varchar(40) not null,              -- 课程名
    Cpno    varchar(4),                        -- 先修课程号
    Ccredit smallint,                          -- 学分
    foreign key (Cpno) references course (Cno) -- 先修课程号外键
)CHAR SET utf8;

-- 先插入没有先修课程的记录
INSERT INTO Course
(Cno, Cname, Cpno, Ccredit)
VALUES ('0001', '高等数学', NULL, 4),
       ('0010', '体育', NULL, 2),
       ('0011', '英语', NULL, 4);

-- 再插入有先修课程的记录
INSERT INTO Course
(Cno, Cname, Cpno, Ccredit)
VALUES ('0002', '线性代数', '0001', 3),
       ('0003', '概率论', '0001', 3),
       ('0004', '数据结构', '0002', 4),
       ('0005', '计算机组成原理', '0004', 4),
       ('0006', '信息系统', '0004', 4),
       ('0007', '编译原理', '0004', 4),
       ('0008', '操作系统', '0003', 4),
       ('0009', '数据处理', '0003', 2);

-- 创建SC表 存储学生选课信息
create table sc
(
    Sno   varchar(20), -- 学号
    Cno   varchar(20), -- 课程号
    Grade smallint,    -- 成绩
    primary key (Sno, Cno),
    foreign key (Sno) references student (Sno),
    foreign key (Cno) references course (Cno)
)CHAR SET utf8;

-- 插入选课信息
INSERT INTO SC
(Sno, Cno, Grade)
VALUES ('20241127', '0001', 95),
       ('20241127', '0002', 88),
       ('20241128', '0003', 76),
       ('20241128', '0004', 85),
       ('20241129', '0005', 90),
       ('20241201', '0006', 70),
       ('20241202', '0007', 60),
       ('20241203', '0008', 92),
       ('20241204', '0009', 78),
       ('20241205', '0010', 85),
       ('20241206', '0011', 80),
       ('20241207', '0001', 65),
       ('20241207', '0007', 76),
       ('20241208', '0002', 55);

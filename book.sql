create database if not exists books_sys;
use books_sys;
# 用户信息表
# 用户id 用户名称 账号 密码 电话号码 是否管理员 是否启用
create table if not exists user_info(
    user_id int primary key auto_increment ,
    user_name varchar(20) ,
    account varchar(20) ,
    password varchar(50) ,
    telephone varchar(11) ,
    admin boolean default false ,
    enable boolean default true
) ;
# 图书信息表
# 图书id 图书名称 封面超链接 ISBN 作者 出版社 价格 总数量 可借数量 是否启用
create table if not exists book_info(
    book_id int primary key auto_increment,
    book_name varchar(50) not null ,
    cover_url varchar(100) ,
    isbn varchar(20) ,
    author varchar(20) ,
    press varchar(20) ,
    price decimal ,
    volume int not null ,
    allow_volume int ,
    enable boolean default true
);
# 图书借出表
# 借出id 状态id 图书id 用户id 借出时间 归还时间 逾期时间
create table if not exists book_borrow(
    borrow_id int primary key auto_increment,
    status_id int ,
    book_id int ,
    user_id int ,
    borrow_date datetime ,
    return_date datetime ,
    overdue_date datetime
);
# 图书状态表
# 状态id 状态
create table if not exists book_status(
    status_id int primary key ,
    status varchar(20)
);

# 显示建表命令
show create table user_info;
select * from book_info;
truncate table book_info;
insert into book_info(book_name,cover_url,isbn,author,press,price,volume,allow_volume,enable)
values('克拉拉与太阳','https://img9.doubanio.com/view/subject/l/public/s33821754.jpg', 9787532786831, '[英] 石黑一雄', '上海译文出版社', 68.00, 100, 100, true),
       ('字母表谜案','https://img1.doubanio.com/view/subject/l/public/s33880929.jpg', 9787555911425, '大山诚一郎', ' 河南文艺出版社', 42.00, 100, 100, true),
       ('置身事内','https://img1.doubanio.com/view/subject/l/public/s33956867.jpg', 9787208171336, '兰小欢', '上海人民出版社', 65.00, 100, 100, true),
       ('刘擎西方现代思想讲义','https://img2.doubanio.com/view/subject/l/public/s33802981.jpg', 9787513342919, '刘擎', '新星出版社', 79.00, 100, 100, true),
       ('下沉年代','https://img2.doubanio.com/view/subject/l/public/s33792562.jpg', 9787549633425, '[美] 乔治·帕克', '文汇出版社', 108.00, 100, 100, true),
       ('文城','https://img1.doubanio.com/view/subject/l/public/s33834057.jpg', 9787530221099, '余华', '北京十月文艺出版社', 59.00, 100, 100, true)

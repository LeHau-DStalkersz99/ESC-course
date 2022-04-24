/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     12/11/2020 04:50:04 PM                       */
/*==============================================================*/
drop database if exists ESC_course;

create database  ESC_course;

use ESC_course;

drop table if exists ADMINS;

drop table if exists CMND;

drop table if exists COURSES;

drop table if exists DETAILPURCHASESBILL;

drop table if exists INDUSTRYS;

drop table if exists MAJORS;

drop table if exists MAYMENTMETHODS;

drop table if exists PARTNERS;

drop table if exists PURCHASESBILL;

drop table if exists STUDENTS;

drop table if exists TOPIC;

drop table if exists VIDEOS;

/*==============================================================*/
/* Table: ADMINS                                                 */
/*==============================================================*/
create table ADMINS
(
   AD_ID                int not null AUTO_INCREMENT,
   AD_CODE              varchar(50),
   AD_FIRSTNAME         nvarchar(100),
   AD_LASTNAME          nvarchar(100),
   AD_DOB               date,
   AD_GENDER            int,
   AD_PHONE             varchar(20),
   AD_EMAIL             varchar(200),
   AD_ADDRESS           nvarchar(200),
   AD_AVARTAR           nvarchar(500),
   AD_USERNAME          varchar(50),
   AD_PASSWORD          varchar(50),
   AD_ROLE              int,
   AD_STATUS            int,
   primary key (AD_ID)
);

/*==============================================================*/
/* Table: CMND                                                  */
/*==============================================================*/
create table CMND
(
   CMND_ID              int not null AUTO_INCREMENT,
   CMND_CODE            varchar(50),
   CMND_HOMETOWN        nvarchar(200),
   CMND_FRONTPHOTO      nvarchar(500),
   CMND_BACKPHOTO       nvarchar(500),
   primary key (CMND_ID)
);

/*==============================================================*/
/* Table: COURSES                                               */
/*==============================================================*/
create table COURSES
(
   COURSE_ID            int not null AUTO_INCREMENT,
   MAJOR_ID             int,
   COURSE_CODE          varchar(50),
   COURSE_NAME          nvarchar(200),
   COURSE_DESCRIPTION   nvarchar(1000),
   COURSE_AUTHOR        nvarchar(200),
   COURSE_CREATEDAY     date,
   COURSE_LASTUPDATE    date,
   COURSE_PICTURE       nvarchar(1000),
   COURSE_PRICE         float(8,2),
   COURSE_STATUS        int,
   primary key (COURSE_ID)
);

/*==============================================================*/
/* Table: DETAILPURCHASESBILL                                   */
/*==============================================================*/
create table DETAILPURCHASESBILL
(
   DPB_ID               int not null AUTO_INCREMENT,
   PURCHASESBILL_ID     int,
   COURSE_ID            int,
   DPB_PRICE            float(8,2),
   DPB_NOTE             nvarchar(200),
   primary key (DPB_ID)
);

/*==============================================================*/
/* Table: INDUSTRYS                                             */
/*==============================================================*/
create table INDUSTRYS
(
   INDUSTRY_ID          int not null AUTO_INCREMENT,
   INDUSTRY_CODE        varchar(50),
   INDUSTRY_NAME        nvarchar(200),
   INDUSTRY_CREATEDAY   date,
   INDUSTRY_STATUS      int,
   primary key (INDUSTRY_ID)
);

/*==============================================================*/
/* Table: MAJORS                                                */
/*==============================================================*/
create table MAJORS
(
   MAJOR_ID             int not null AUTO_INCREMENT,
   INDUSTRY_ID          int,
   MAJOR_CODE           varchar(50),
   MAJOR_NAME           nvarchar(200),
   MAJOR_CREATEDAY      date,
   MAJOR_STATUS         int,
   primary key (MAJOR_ID)
);

/*==============================================================*/
/* Table: MAYMENTMETHODS                                        */
/*==============================================================*/
create table PAYMENTMETHODS
(
   PAYM_ID              int not null AUTO_INCREMENT,
   PAYM_NAME            varchar(200),
   PAYM_NOTE            nvarchar(200),
   PAYM_STATUS          int,
   primary key (PAYM_ID)
);

/*==============================================================*/
/* Table: PARTNERS                                              */
/*==============================================================*/
create table PARTNERS
(
   PARTNER_ID           int not null AUTO_INCREMENT,
   PARTNER_CODE         varchar(50),
   PARTNER_FIRSTNAME    nvarchar(50),
   PARTNER_LASTNAME     nvarchar(100),
   PARTNER_GENDER       int,
   PARTNER_PHONE        varchar(20),
   PARTNER_EMAIL        varchar(200),
   PARTNER_DOB          date,
   PARTNER_ADDRESS      nvarchar(200),
   PARTNER_AVARTAR      nvarchar(1000),
   PARTNER_USERNAME     varchar(200),
   PARTNER_PASSWORD     varchar(100),
   PARTNER_STATUS       int,
   primary key (PARTNER_ID)
);

/*==============================================================*/
/* Table: PURCHASESBILL                                         */
/*==============================================================*/
create table PURCHASESBILL
(
   PURCHASESBILL_ID     int not null AUTO_INCREMENT,
   PAYM_ID              int,
   STUDENT_ID           int,
   PURCHASESBILL_CODE   varchar(50),
   PURCHASESBILL_CREATEDAY date,
   PURCHASESBILL_TOTALMONEY float(8,2),
   PURCHASESBILL_NOTE   nvarchar(200),
   PURCHASESBILL_STATUS int,
   primary key (PURCHASESBILL_ID)
);

/*==============================================================*/
/* Table: STUDENTS                                              */
/*==============================================================*/
create table STUDENTS
(
   STUDENT_ID           int not null AUTO_INCREMENT,
   STUDENT_CODE         varchar(50),
   STUDENT_FIRSTNAME    nvarchar(50),
   STUDENT_LASTNAME     nvarchar(100),
   SUTDENT_GENDER       int,
   STUDENT_PHONE        varchar(20),
   STUDENT_EMAIL        varchar(200),
   STUDENT_PASSWORD     varchar(100),
   STUDENT_DOB          date,
   STUDENT_ADDRESS      nvarchar(200),
   STUDENT_AVATAR       nvarchar(1000),
   STUDENT_CREATEDAY    date,
   STUDENT_STATUS       int,
   primary key (STUDENT_ID)
);

/*==============================================================*/
/* Table: TOPIC                                                 */
/*==============================================================*/
create table TOPIC
(
   TOPIC_ID             int not null AUTO_INCREMENT,
   COURSE_ID            int,
   TOPIC_CODE           varchar(50),
   TOPIC_NAME           nvarchar(200),
   TOPIC_DESCRIPTION    nvarchar(200),
   TOPIC_CREATEDAY      date,
   TOPIC_STATUS         int,
   primary key (TOPIC_ID)
);

/*==============================================================*/
/* Table: VIDEOS                                                */
/*==============================================================*/
create table VIDEOS
(
   TOPIC_ID             int not null ,
   VIDEO_ID             int not null AUTO_INCREMENT,
   VIDEO_CODE           varchar(50),
   VIDEO_NAME           nvarchar(200),
   VIDEO_DESCRIPTION    nvarchar(500),
   VIDEO_CREATEDAY      date,
   VIDEO_URL            nvarchar(2000),
   VIDEO_STATUS         int,
   primary key (VIDEO_ID)
);

alter table COURSES add constraint FK_THUOC_CHUYEN_NGANH foreign key (MAJOR_ID)
      references MAJORS (MAJOR_ID) on delete restrict on update restrict;

alter table DETAILPURCHASESBILL add constraint FK_CTHD_THUOC_HOA_DON foreign key (PURCHASESBILL_ID)
      references PURCHASESBILL (PURCHASESBILL_ID) on delete restrict on update restrict;

alter table DETAILPURCHASESBILL add constraint FK_KHOA_HOC_CO_CTHD foreign key (COURSE_ID)
      references COURSES (COURSE_ID) on delete restrict on update restrict;

alter table MAJORS add constraint FK_THUOC_NGANH foreign key (INDUSTRY_ID)
      references INDUSTRYS (INDUSTRY_ID) on delete restrict on update restrict;

alter table PURCHASESBILL add constraint FK_HOA_DON_CO_PHUONG_THUC_THANH_TOAN foreign key (PAYM_ID)
      references PAYMENTMETHODS (PAYM_ID) on delete restrict on update restrict;

alter table PURCHASESBILL add constraint FK_HOC_VIEN_CO_HOA_DON foreign key (STUDENT_ID)
      references STUDENTS (STUDENT_ID) on delete restrict on update restrict;

alter table TOPIC add constraint FK_THUOC_KHOA_HOC foreign key (COURSE_ID)
      references COURSES (COURSE_ID) on delete restrict on update restrict;

alter table VIDEOS add constraint FK_THUOC_CHU__E foreign key (TOPIC_ID)
      references TOPIC (TOPIC_ID) on delete restrict on update restrict;



/*======================================================================================================================================================*/
/* Table: INDUSTRY                                               */
INSERT INTO `esc_course`.`industrys` (`INDUSTRY_CODE`, `INDUSTRY_NAME`, `INDUSTRY_CREATEDAY`, `INDUSTRY_STATUS`) VALUES ('CNTT', 'Công Nghệ Thông Tin', '2020-11-13', '1');
INSERT INTO `esc_course`.`industrys` (`INDUSTRY_CODE`, `INDUSTRY_NAME`, `INDUSTRY_CREATEDAY`, `INDUSTRY_STATUS`) VALUES ('KT', 'Kinh Tế', '2020-11-13', '1');

/*======================================================================================================================================================*/
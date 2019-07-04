##Rest Client JSON Post Request Samle

###header>custom header -->  content_type:application/json
###METHOD:POST


{
"empId":"1003",
"name": "sugyani",
"status": "T",
"tenure": "1",
"phone": "",
"email":"",
"doj":"2015-02-14",
"wl":"",
"hl":"",
"cl":"",
"rmid":"NA",
"roleid":"1",
"vertid":"2",
"acctid":"4"
}



##MYSQL DATABASE QUERIES:

INSERT INTO `database`.`employee` (`EMPID`, `NAME`, `STATUS`, `TENURE`, `ISRELOCATE`) VALUES ('1', 'sugyani', 'F', '2', 'NA');

INSERT INTO `database`.`employee` (`EMPID`, `NAME`, `STATUS`, `TENURE`, `ISRELOCATE`) VALUES ('2', 'sambit', 'T', '5', 'T');


INSERT INTO `database`.`employee`
(`EMPID`,
`NAME`,
`STATUS`,
`TENURE`,
`PHONE`,
`EMAIL`,
`JOINING_DATE`,
`WORKLOC`,
`CURRENTLOC`,
`HOMELOC`,
`ISRELOCATE`,
`ROLEID`,
`VERTICALID`,
`ACCOUNTID`)
VALUES
('1000','patnaik',
'T',
'1','','',
'2015-02-14','','','','NA','1','2','2');


drop table if exists `database`.`employee`;

CREATE TABLE `database`.`employee` (
  `EMPID` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(100) DEFAULT NULL,
  `STATUS` enum('T','F') NOT NULL DEFAULT 'F',
  `TENURE` INT(3) DEFAULT NULL,
  `PHONE` CHAR(15) DEFAULT NULL,
   `EMAIL` VARCHAR(52) DEFAULT NULL,
  `JOINING_DATE` DATE DEFAULT NULL,
   `WORKLOC`VARCHAR(52) DEFAULT NULL,
`CURRENTLOC`VARCHAR(52) DEFAULT NULL,
`HOMELOC` VARCHAR(52) DEFAULT NULL,
`ISRELOCATE`enum('T','F' ,'NA') NOT NULL DEFAULT 'NA',
`ROLEID` INT(11) DEFAULT NULL,
`VERTICALID` INT(11) DEFAULT NULL,
`ACCOUNTID` INT(11) DEFAULT NULL,
  PRIMARY KEY (`EMPID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


##POSTGRES DATABASE QUERIES

CREATE TYPE e_isrelocate AS ENUM
    ('T', 'F', 'NA');

CREATE TYPE e_status AS ENUM
    ('T', 'F');

CREATE TABLE employee
(
    empid integer NOT NULL DEFAULT nextval('employee_empid_seq'::regclass),
    name character varying(100) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    status e_status NOT NULL DEFAULT 'F'::e_status,
    tenure integer,
    phone character(15) COLLATE pg_catalog."default" DEFAULT NULL::bpchar,
    email character varying(52) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    joining_date date,
    workloc character varying(52) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    currentloc character varying(52) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    homeloc character varying(52) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    isrelocate e_isrelocate NOT NULL DEFAULT 'NA'::e_isrelocate,
    roleid integer,
    verticalid integer,
    accountid integer,
    CONSTRAINT employee_pkey PRIMARY KEY (empid)
)
WITH (
    OIDS = FALSE
)

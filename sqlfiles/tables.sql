CREATE TABLE user(
	id INT AUTO_INCREMENT,
	username VARCHAR(20),
	email VARCHAR(40),
	password VARCHAR(40),
	isverified TINYINT(1),
	datecreate BIGINT,
	PRIMARY KEY (id)
);
CREATE TABLE friends(
	id INT AUTO_INCREMENT,
	username VARCHAR(40),
	friendname VARCHAR(40),
	PRIMARY KEY (id)
);
CREATE TABLE taskusers(
	taskid BIGINT,
	relativetaskid BIGINT,
	username VARCHAR(40),
	readonly TINYINT(1),
	PRIMARY KEY(taskid)
);
CREATE TABLE task(
	taskid BIGINT,
	datecreate BIGINT,
	datechange BIGINT,
	tasktext LONGTEXT,
	tasktitle VARCHAR(255),
	isarchieved TINYINT(1),
	priority INT,
	PRIMARY KEY(taskid)
);
CREATE TABLE loginlog(
	id INT AUTO_INCREMENT,
	username VARCHAR(40),
	logintime BIGINT,
	logouttime BIGINT,
	ip VARCHAR(255),
	PRIMARY KEY(id)
);
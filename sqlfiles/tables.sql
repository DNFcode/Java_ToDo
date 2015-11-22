CREATE TABLE USER(
	USER_ID BIGINT AUTO_INCREMENT NOT NULL,
	USER_NAME VARCHAR(20),
	EMAIL VARCHAR(40),
	PASSWORD VARCHAR(40),
	IS_VERIFIED TINYINT(1) NOT NULL,
  IS_ADMIN TINYINT(1) NOT NULL,
	DATE_CREATE BIGINT,
	PRIMARY KEY (USER_ID)
) ENGINE=INNODB;
CREATE TABLE FRIENDS(
	FRIENDS_ID BIGINT AUTO_INCREMENT NOT NULL,
	FRIEND_REQUESTER BIGINT,
	FRIEND_RECEIVER BIGINT,
	PRIMARY KEY (FRIENDS_ID),
  FOREIGN KEY (FRIEND_REQUESTER) REFERENCES USER(USER_ID)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  FOREIGN KEY (FRIEND_RECEIVER) REFERENCES  USER(USER_ID)
    ON UPDATE CASCADE
    ON DELETE CASCADE
) ENGINE=INNODB;
CREATE TABLE TASK(
	TASK_ID BIGINT AUTO_INCREMENT NOT NULL,
  LIST_ID BIGINT,
	TASK_TEXT LONGTEXT,
	IS_DONE VARCHAR(255),
	PRIORITY INT,
	PRIMARY KEY(TASK_ID),
  FOREIGN KEY(LIST_ID) REFERENCES TASK_LIST(LIST_ID)
    ON UPDATE CASCADE
    ON DELETE SET NULL
) ENGINE=INNODB;
CREATE TABLE LOGIN_LOG(
	LOGIN_ID BIGINT AUTO_INCREMENT NOT NULL,
	USER_ID BIGINT,
	LOGIN_TIME BIGINT,
	LOGOUT_TIME BIGINT,
	IP VARCHAR(255),
	PRIMARY KEY(LOGIN_ID),
  FOREIGN KEY(USER_ID) REFERENCES USER(USER_ID)
) ENGINE=INNODB;
CREATE TABLE TASK_LIST(
  LIST_ID BIGINT AUTO_INCREMENT,
  TITLE VARCHAR(20),
  IS_PUBLIC TINYINT(1) NOT NULL,
  AUTHOR BIGINT,
  DATE_CREATE BIGINT,
  DATE_CHANGE BIGINT,
  PRIMARY KEY(LIST_ID),
  FOREIGN KEY(AUTHOR) REFERENCES USER(USER_ID)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
) ENGINE=INNODB;
CREATE TABLE TASKLIST_USERS(
  LIST_USERS_ID BIGINT AUTO_INCREMENT,
  LIST_ID BIGINT NOT NULL,
  USER_ID BIGINT NOT NULL,
  MAY_EDIT TINYINT(1) NOT NULL,
  PRIMARY KEY(LIST_USERS_ID),
  FOREIGN KEY(USER_ID) REFERENCES USER(USER_ID)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  FOREIGN KEY(LIST_ID) REFERENCES TASK_LIST(LIST_ID)
    ON UPDATE CASCADE
    ON DELETE CASCADE
) ENGINE=INNODB;
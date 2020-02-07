
CREATE TABLE account(
  person_id int NOT NULL AUTO_INCREMENT,
  username VARCHAR(40),
  password VARCHAR(40),
  sex VARCHAR(10),
  email VARCHAR(40),
  CONSTRAINT pk_account PRIMARY KEY(person_id,email)
)ENGINE=InnoDB;

CREATE TABLE blog (
  person_id int NOT NULL ,
  blog_id int NOT NULL AUTO_INCREMENT,
  content    LONGTEXT,
  CONSTRAINT pk_blog PRIMARY KEY (blog_id),
  CONSTRAINT fk_blog_person FOREIGN KEY (person_id)
  REFERENCES account(person_id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB;

create TABLE comments(
  person_id INT NOT NULL ,
  blog_id INT NOT NULL AUTO_INCREMENT,
  comment LONGTEXT,
  CONSTRAINT pk_comments PRIMARY KEY (blog_id),
  CONSTRAINT fk_comment_blog_person FOREIGN KEY (person_id,blog_id)
  REFERENCES blog(person_id,blog_id)  ON DELETE CASCADE ON UPDATE CASCADE

)ENGINE=InnoDB;


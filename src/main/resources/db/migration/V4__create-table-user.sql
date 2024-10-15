CREATE TABLE t_reg_user (
  id_user BIGINT NOT NULL AUTO_INCREMENT,
  str_username VARCHAR(100) NOT NULL,
  str_password VARCHAR(255) NOT NULL,
  CONSTRAINT pk_reg_user PRIMARY KEY (id_user)
);


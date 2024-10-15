CREATE TABLE t_reg_entity (
  id_entity BIGINT NOT NULL AUTO_INCREMENT,
  str_status VARCHAR(20) DEFAULT 'ACTIVE' NOT NULL,
  str_entity_type VARCHAR(20) NOT NULL,
  str_description VARCHAR(150) NOT NULL,
  str_document VARCHAR(14) DEFAULT NULL,
  CONSTRAINT pk_reg_entity PRIMARY KEY (id_entity)
);


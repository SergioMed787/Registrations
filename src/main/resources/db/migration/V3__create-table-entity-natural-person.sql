CREATE TABLE t_reg_entity_natural_person (
  id_entity BIGINT NOT NULL,
  str_name VARCHAR(150) NOT NULL,
  str_social_security_number CHAR(11) NOT NULL,
  str_general_register VARCHAR(20),
  str_gender  VARCHAR(10) NOT NULL,
  CONSTRAINT pk_reg_entity_natural_person PRIMARY KEY (id_entity)
);

ALTER TABLE t_reg_entity_natural_person ADD CONSTRAINT fk_reg_entity_natural_person FOREIGN KEY (id_entity)
REFERENCES t_reg_entity(id_entity) ON DELETE CASCADE;
CREATE TABLE t_reg_entity_legal_entity (
  id_entity BIGINT NOT NULL,
  str_company_name VARCHAR(150) NOT NULL,
  str_corporate_id CHAR(14) NOT NULL,
  str_state_registration VARCHAR(20),
  CONSTRAINT pk_reg_entity_legal_entity PRIMARY KEY (id_entity)
);

ALTER TABLE t_reg_entity_legal_entity ADD CONSTRAINT fk_reg_entity_legal_entity FOREIGN KEY (id_entity)
REFERENCES t_reg_entity(id_entity) ON DELETE CASCADE;
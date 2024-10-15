package reg.api.domain.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reg.api.general.GeneralGender;
import reg.api.general.GeneralRegStatusEnum;

import java.io.Serial;
import java.io.Serializable;

@Table(name = "t_reg_entity_natural_person")
@Entity(name = "NaturalPerson")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@PrimaryKeyJoinColumn(name="id_entity")
public class NaturalPerson extends reg.api.domain.entity.Entity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_entity")
    private Long id;

    @Column(name = "str_name", nullable = false, columnDefinition = "VARCHAR(150)")
    private String name;

    @Column(name = "str_social_security_number", nullable = false, columnDefinition = "VARCHAR(11)")
    private String socialSecurityNumber; //In Brazil Cadastro Pessoa Física - CPF

    @Column(name = "str_general_register", columnDefinition = "VARCHAR(20)")
    private String generalRegister; //Brazil Registro Geral - RG

    @Enumerated(EnumType.STRING)
    @Column(name = "str_gender", nullable = false, columnDefinition = "VARCHAR(20)")
    private GeneralGender gender;

    public NaturalPerson(NaturalPersonData data){
        super.setStatus(GeneralRegStatusEnum.ACTIVE);
        super.setTypeEntity(data.typeEntity());
        super.setDescription(data.name()); //Populates the parent table for lookup
        super.setDocument(data.socialSecurityNumber()); //Populates the parent table for lookup

        this.name = data.name();
        this.socialSecurityNumber = data.socialSecurityNumber();
        this.generalRegister = data.generalRegister();
        this.gender = data.gender();
    }

    public void updateNaturalPerson(NaturalPersonDataUpdate data) {

        if (data.statusEnum() != null) {
            super.setStatus(data.statusEnum());
        }
        if (data.entityType() != null) {
            super.setTypeEntity(data.entityType());
        }
        if (data.name() != null){
            super.setDescription(data.name());
        }
        if (data.socialSecurityNumber() != null){
            super.setDocument(data.socialSecurityNumber());
        }
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.socialSecurityNumber() != null) {
            this.socialSecurityNumber = data.socialSecurityNumber();
        }
        if (data.generalRegister() != null) {
            this.generalRegister = data.generalRegister();
        }
        if (data.gender() != null) {
            this.gender = data.gender();
        }
    }
}

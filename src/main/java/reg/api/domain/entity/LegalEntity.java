package reg.api.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reg.api.general.GeneralRegStatusEnum;

import java.io.Serial;
import java.io.Serializable;

@Table(name = "t_reg_entity_legal_entity")
@Entity(name = "LegalEntity")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@PrimaryKeyJoinColumn(name="id_entity")
public class LegalEntity extends reg.api.domain.entity.Entity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_entity")
    private Long id;

    @Column(name = "str_company_name", nullable = false, columnDefinition = "VARCHAR(150)")
    private String companyName;

    @Column(name = "str_corporate_id", nullable = false, columnDefinition = "VARCHAR(14)")
    private String corporateId; //In Brazil - Cadastro Nacional Pessoa Jurídica - CNPJ

    @Column(name = "str_state_registration", columnDefinition = "VARCHAR(20)")
    private String stateRegistration; //In Brazil - Inscrição Estadual - IE

    public LegalEntity(LegalEntityData data){
        super.setStatus(GeneralRegStatusEnum.ACTIVE);
        super.setTypeEntity(data.typeEntity());
        super.setDescription(data.companyName()); //Populates the parent table for lookup
        super.setDocument(data.corporateId()); //Populates the parent table for lookup

        this.companyName = data.companyName();
        this.corporateId = data.corporateId();
        this.stateRegistration = data.stateRegistration();
    }

    public void updateLegalEntity(LegalEntityDataUpdate data) {
        if (data.statusEnum() != null) {
            super.setStatus(data.statusEnum());
        }
        if (data.entityType() != null) {
            super.setTypeEntity(data.entityType());
        }
        if (data.companyName() != null){
            super.setDescription(data.companyName());
        }
        if (data.corporateId() != null){
            super.setDocument(data.corporateId());
        }
        if (data.companyName() != null){
            this.companyName = data.companyName();
        }
        if (data.corporateId() != null){
            this.corporateId = data.corporateId();
        }
        if (data.stateRegistration() != null){
            this.stateRegistration = data.stateRegistration();
        }
    }
}

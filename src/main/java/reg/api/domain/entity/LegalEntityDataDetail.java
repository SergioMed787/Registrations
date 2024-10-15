package reg.api.domain.entity;

import reg.api.general.GeneralRegStatusEnum;

public record LegalEntityDataDetail(
        Long id,
        GeneralRegStatusEnum statusEnum,
        EntityType entityType,
        String companyName,
        String corporateId,
        String stateRegistration) {

    public LegalEntityDataDetail(LegalEntity data){
        this(data.getId(),
             data.getStatus(),
             data.getTypeEntity(),
             data.getCompanyName(),
             data.getCorporateId(),
             data.getStateRegistration());
    }
}

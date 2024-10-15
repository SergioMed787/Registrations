package reg.api.domain.entity;

import reg.api.general.GeneralGender;
import reg.api.general.GeneralRegStatusEnum;

public record NaturalPersonDataDetail(
        Long id,
        GeneralRegStatusEnum statusEnum,
        EntityType entityType,
        String name,
        String socialSecurityNumber,
        String generalRegister,
        GeneralGender gender) {

    public NaturalPersonDataDetail(NaturalPerson data){
        this(data.getId(),
             data.getStatus(),
             data.getTypeEntity(),
             data.getName(),
             data.getSocialSecurityNumber(),
             data.getGeneralRegister(),
             data.getGender());
    }
}

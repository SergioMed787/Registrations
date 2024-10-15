package reg.api.domain.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import reg.api.general.GeneralGender;
import reg.api.general.GeneralRegStatusEnum;

public record NaturalPersonDataUpdate(
        @NotNull
        Long id,
        GeneralRegStatusEnum statusEnum,
        EntityType entityType,
        String name,
        @Pattern(regexp = "\\d{11}")
        String socialSecurityNumber,
        String generalRegister,
        GeneralGender gender
) {
}

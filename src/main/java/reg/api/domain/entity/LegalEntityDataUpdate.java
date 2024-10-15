package reg.api.domain.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import reg.api.general.GeneralRegStatusEnum;

public record LegalEntityDataUpdate(
        @NotNull
        Long id,
        GeneralRegStatusEnum statusEnum,
        EntityType entityType,
        String companyName,
        @Pattern(regexp = "\\d{14}")
        String corporateId,
        String stateRegistration) {
}

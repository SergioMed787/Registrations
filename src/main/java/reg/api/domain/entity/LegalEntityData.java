package reg.api.domain.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record LegalEntityData (
        @NotNull
        EntityType typeEntity,
        @NotBlank
        String companyName,
        @Pattern(regexp = "\\d{14}")
        String corporateId,
        String stateRegistration
) {
}

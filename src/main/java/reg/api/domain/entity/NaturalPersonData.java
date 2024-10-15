package reg.api.domain.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import reg.api.general.GeneralGender;

public record NaturalPersonData(
        @NotNull
        EntityType typeEntity,
        @NotBlank
        String name,
        @Pattern(regexp = "\\d{11}")
        String socialSecurityNumber,
        String generalRegister,
        @NotNull
        GeneralGender gender) {
}

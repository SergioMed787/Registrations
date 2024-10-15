package reg.api.domain.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import reg.api.general.GeneralRegStatusEnum;

public record EntityData (
    Long id,
    @NotNull
    GeneralRegStatusEnum statusEnum,
    @NotNull
    EntityType typeEntity,
    @NotBlank
    String description,
    String document) {

    public EntityData(Entity entity){
        this(entity.getId(), entity.getStatus(), entity.getTypeEntity(), entity.getDescription(), entity.getDocument());
    }
}

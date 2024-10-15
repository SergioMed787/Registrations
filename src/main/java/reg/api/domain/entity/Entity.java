package reg.api.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import reg.api.general.GeneralRegStatus;
import reg.api.general.GeneralRegStatusEnum;

import java.io.Serial;
import java.io.Serializable;


@Table(name = "t_reg_entity")
@jakarta.persistence.Entity(name = "Entity")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id", callSuper = false)
public class Entity extends GeneralRegStatus implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entity")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "str_status", nullable = false, columnDefinition = "VARCHAR(20)")
    private GeneralRegStatusEnum status;

    @Enumerated(EnumType.STRING)
    @Column(name = "str_entity_type", nullable = false, columnDefinition = "VARCHAR(20)")
    private EntityType typeEntity;

    @Column(name = "str_description", nullable = false, columnDefinition = "VARCHAR(150)")
    private String description;

    @Column(name = "str_document", unique = true, columnDefinition = "VARCHAR(20)")
    private String document;
}

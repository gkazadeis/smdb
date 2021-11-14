package openbet.codehub.smdb.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PERSONS")
@SequenceGenerator(name = "idGenerator", sequenceName = "PERSONS_SEQ", initialValue = 1, allocationSize = 1)
public class Person extends BaseModel {
    @NotNull(message = "Person's first name should be present.")
    @Column(length = 20, nullable = false)
    private String name;

    @NotNull(message = "Person's surname should be present.")
    @Column(length = 20, nullable = false)
    private String surname;
}

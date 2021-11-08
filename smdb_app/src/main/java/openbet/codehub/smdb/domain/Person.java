package openbet.codehub.smdb.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Person extends BaseModel {
    @NotNull(message = "Person's first name should be present.")
    @Column(length = 20, nullable = false)
    private String name;

    @NotNull(message = "Person's surname should be present.")
    // Making this unique for testing purposes
    @Column(length = 20, nullable = false, unique = true)
    private String surname;
}

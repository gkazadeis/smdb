package openbet.codehub.smdb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PRODUCERS")
@SequenceGenerator(name = "idGenerator", sequenceName = "PRODUCERS_SEQ", initialValue = 1, allocationSize = 1)
public class Producer extends Person {
    @JsonIgnore
    @ManyToMany(mappedBy="producers",fetch=FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Movie> movies = new HashSet<>();
}

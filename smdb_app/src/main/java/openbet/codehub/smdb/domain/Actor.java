package openbet.codehub.smdb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class Actor extends Person {

    @JsonIgnore
    @ManyToMany(mappedBy="actors",fetch=FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Movie> movies = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy="actors",fetch=FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Series> series = new HashSet<>();
}

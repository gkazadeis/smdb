package openbet.codehub.smdb.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ACTORS") // How to create an index to a column that exists in parent class?
@SequenceGenerator(name = "idGenerator", sequenceName = "ACTORS_SEQ", initialValue = 1, allocationSize = 1)
public class Actor extends Person {
    @ManyToMany
    @JoinTable(
            name = "movie_stars",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    Set<Movie> starsInMovies;

    @ManyToMany
    @JoinTable(
            name = "series_stars",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "series_id"))
    Set<Series> starsInSeries;
}

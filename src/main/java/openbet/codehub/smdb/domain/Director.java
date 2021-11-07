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
@Table(name = "DIRECTORS")
@SequenceGenerator(name = "idGenerator", sequenceName = "DIRECTORS_SEQ", initialValue = 1, allocationSize = 1)
public class Director extends Person {
    @ManyToMany
    @JoinTable(
            name = "movie_directs",
            joinColumns = @JoinColumn(name = "director_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    Set<Movie> directsMovies;

    @ManyToMany
    @JoinTable(
            name = "series_directs",
            joinColumns = @JoinColumn(name = "director_id"),
            inverseJoinColumns = @JoinColumn(name = "series_id"))
    Set<Series> directsSeries;
}

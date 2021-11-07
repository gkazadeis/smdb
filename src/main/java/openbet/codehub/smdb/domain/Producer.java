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
@Table(name = "PRODUCERS")
@SequenceGenerator(name = "idGenerator", sequenceName = "PRODUCERS_SEQ", initialValue = 1, allocationSize = 1)
public class Producer extends Person {
    @ManyToMany
    @JoinTable(
            name = "movie_produces",
            joinColumns = @JoinColumn(name = "producer_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    Set<Movie> producesMovies;

    @ManyToMany
    @JoinTable(
            name = "series_produces",
            joinColumns = @JoinColumn(name = "producer_id"),
            inverseJoinColumns = @JoinColumn(name = "series_id"))
    Set<Series> producesSeries;
}

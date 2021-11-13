package openbet.codehub.smdb.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ACTORS") // How to create an index to a column that exists in parent class?
@SequenceGenerator(name = "idGenerator", sequenceName = "ACTORS_SEQ", initialValue = 1, allocationSize = 1)
public class Actor extends BaseModel {

    @NotNull(message = "Actor's first name should be present.")
    @Column(length = 20, nullable = false)
    private String name;

    @NotNull(message = "Actor's surname should be present.")
    // Making this unique for testing purposes
    @Column(length = 20, nullable = false, unique = true)
    private String surname;

    @JsonIgnore
    @ManyToMany(mappedBy="actors",fetch=FetchType.EAGER)
    private List<Movie> movies;

    /*@ManyToMany
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
    Set<Series> starsInSeries;*/
}

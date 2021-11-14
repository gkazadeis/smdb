package openbet.codehub.smdb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;;
import java.util.HashSet;
import java.util.Set;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "MOVIES", indexes = {@Index(columnList = "category")})
@SequenceGenerator(name = "idGenerator", sequenceName = "MOVIES_SEQ", initialValue = 1, allocationSize = 1)
public class Movie extends Feature {

    @NotNull(message = "Movie's year should be present.")
    @Column(nullable = false)
    private Integer year;

    @Singular
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="ACTORS_MOVIES",
            joinColumns= @JoinColumn(name="MOVIE_ID", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="ACTOR_ID", referencedColumnName="ID")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Actor> actors = new HashSet<>();

    @Singular
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="DIRECTORS_MOVIES",
            joinColumns= @JoinColumn(name="MOVIE_ID", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="DIRECTOR_ID", referencedColumnName="ID")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Director> directors = new HashSet<>();

    @Singular
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="PRODUCERS_MOVIES",
            joinColumns= @JoinColumn(name="MOVIE_ID", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="PRODUCER_ID", referencedColumnName="ID")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Producer> producers = new HashSet<>();

}

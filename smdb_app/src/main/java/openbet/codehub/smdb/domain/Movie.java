package openbet.codehub.smdb.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "MOVIES", indexes = {@Index(columnList = "category")})
@SequenceGenerator(name = "idGenerator", sequenceName = "MOVIES_SEQ", initialValue = 1, allocationSize = 1)
public class Movie extends BaseModel {

    @NotNull(message = "Movie's title should be present.")
    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 250)
    private String description;

    @NotNull(message = "Movie's year should be present.")
    @Column(nullable = false)
    private Integer year;

    @Min(value = 0, message = "Rating cannot be lower than 0")
    @Max(value = 10, message = "Rating cannot be lower than 10")
    @Column(precision = 4, scale = 2)
    private Double rating;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="ACTORS_MOVIES",
            joinColumns= @JoinColumn(name="MOVIE_ID", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="ACTOR_ID", referencedColumnName="ID")
    )
    private List<Actor> actors;

    // Many to many, good luck with that
    /*@Singular
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "starsInMovies")
    private Set<Actor> actors;

    @Singular
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "directsMovies")
    private Set<Director> directors;

    @Singular
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "producesMovies")
    private Set<Producer> producers;*/
}

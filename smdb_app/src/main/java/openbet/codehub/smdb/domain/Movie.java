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
@Table(name = "MOVIES", indexes = {@Index(columnList = "category")})
@SequenceGenerator(name = "idGenerator", sequenceName = "MOVIES_SEQ", initialValue = 1, allocationSize = 1)
public class Movie extends BaseModel {

    @NotNull(message = "Movie's title should be present.")
    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 250, nullable = false)
    private String description;

    @NotNull(message = "Movie's year should be present.")
    @Column(nullable = false)
    private Integer year;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private Category category;

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

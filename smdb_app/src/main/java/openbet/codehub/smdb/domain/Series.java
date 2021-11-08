package openbet.codehub.smdb.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "SERIES", indexes = {@Index(columnList = "category")})
@SequenceGenerator(name = "idGenerator", sequenceName = "SERIES_SEQ", initialValue = 1, allocationSize = 1)
public class Series extends BaseModel {
    @NotNull(message = "Series's title should be present.")
    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 250, nullable = false)
    private String description;

    @NotNull(message = "Series's start year should be present.")
    @Column(nullable = false)
    // Should this be Integer instead?
    private int startYear;

    @Column
    // Should this be Integer instead?
    private int endYear;

    @NotNull(message = "Series's number of seasons year should be present.")
    @Column(nullable = false)
    // Should this be Integer instead?
    private int seasons;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private Category category;
/*
    // Many to many, good luck with that
    @Singular
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "starsInSeries")
    private Set<Actor> actors;

    @Singular
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "directsSeries")
    private Set<Director> directors;

    @Singular
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "producesSeries")
    private Set<Producer> producers;*/
}

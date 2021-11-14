package openbet.codehub.smdb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "SERIES", indexes = {@Index(columnList = "category")})
@SequenceGenerator(name = "idGenerator", sequenceName = "SERIES_SEQ", initialValue = 1, allocationSize = 1)
public class Series extends Feature {

    @NotNull(message = "Series's start year should be present.")
    @Column(nullable = false)
    private Integer startYear;

    @Column
    private Integer endYear;

    @NotNull(message = "Series's number of seasons year should be present.")
    @Column(nullable = false)
    private Integer seasons;

    @Singular
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="ACTORS_SERIES",
            joinColumns= @JoinColumn(name="SERIES_ID", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="PERSON_ID", referencedColumnName="ID")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Person> actors = new HashSet<>();

    @Singular
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="DIRECTORS_SERIES",
            joinColumns= @JoinColumn(name="SERIES_ID", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="PERSON_ID", referencedColumnName="ID")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Person> directors = new HashSet<>();

    @Singular
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="PRODUCERS_SERIES",
            joinColumns= @JoinColumn(name="SERIES_ID", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="PERSON_ID", referencedColumnName="ID")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Person> producers = new HashSet<>();
}

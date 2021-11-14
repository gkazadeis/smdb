package openbet.codehub.smdb.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import openbet.codehub.smdb.domain.Movie;
import openbet.codehub.smdb.domain.Person;
import openbet.codehub.smdb.domain.Series;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDetails {
    @NotNull
    private Person person;
    @NotNull
    private Set<Movie> movies;
    @NotNull
    private Set<Series> series;
}
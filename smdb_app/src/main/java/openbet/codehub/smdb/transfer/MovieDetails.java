package openbet.codehub.smdb.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import openbet.codehub.smdb.domain.*;

import javax.validation.constraints.NotNull;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDetails {
    @NotNull
    private Movie movie;
    @NotNull
    private Set<Person> actors;
    @NotNull
    private Set<Person> directors;
    @NotNull
    private Set<Person> producers;
}

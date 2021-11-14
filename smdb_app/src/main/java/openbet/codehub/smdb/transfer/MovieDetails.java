package openbet.codehub.smdb.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import openbet.codehub.smdb.domain.Actor;
import openbet.codehub.smdb.domain.Director;
import openbet.codehub.smdb.domain.Movie;
import openbet.codehub.smdb.domain.Producer;

import javax.validation.constraints.NotNull;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDetails {
    @NotNull
    private Movie movie;
    @NotNull
    private Set<Actor> actors;
    @NotNull
    private Set<Director> directors;
    @NotNull
    private Set<Producer> producers;
}

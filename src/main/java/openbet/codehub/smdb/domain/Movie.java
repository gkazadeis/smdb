package openbet.codehub.smdb.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.experimental.Delegate;

import java.util.List;

@Data
@Builder
public class Movie {
    private String title;
    private String description;
    private int year;
    private Category category;
    @Singular
    private List<Actor> actors;
    @Singular
    private List<Director> directors;
    @Singular
    private List<Producer> producers;
}

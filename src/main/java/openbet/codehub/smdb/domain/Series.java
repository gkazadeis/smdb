package openbet.codehub.smdb.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class Series {
    private String title;
    private String description;
    private int startYear;
    private int endYear;
    private int seasons;
    private Category category;
    @Singular
    private List<Actor> actors;
    @Singular
    private List<Director> directors;
    @Singular
    private List<Producer> producers;
}

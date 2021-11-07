package openbet.codehub.smdb.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {
    private String title;
    private String description;
    private int year;
    private Category category;
}

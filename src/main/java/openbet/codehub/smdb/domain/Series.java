package openbet.codehub.smdb.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Series {
    private String title;
    private String description;
    private int year;
    private int seasons;
    private Category category;
}

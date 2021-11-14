package openbet.codehub.smdb.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class Feature extends BaseModel {
    @NotNull(message = "Title should be present.")
    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 250)
    private String description;

    @Min(value = 0, message = "Rating cannot be lower than 0")
    @Max(value = 10, message = "Rating cannot be lower than 10")
    @Column(precision = 4, scale = 2)
    private Double rating;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private Category category;
}

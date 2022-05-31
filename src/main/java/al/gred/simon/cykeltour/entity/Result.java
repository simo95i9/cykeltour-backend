package al.gred.simon.cykeltour.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Duration time;

    private Double mountainPoints;
    private Double flatPoints;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Rider rider;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Stage stage;
}

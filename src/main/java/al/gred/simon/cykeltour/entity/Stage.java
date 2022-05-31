package al.gred.simon.cykeltour.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private String description;

    @OneToMany(mappedBy = "stage", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Result> results = new HashSet<>();
}

package al.gred.simon.cykeltour.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate birth;

    private String country;
    private String flag;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    private Team team;

    @OneToMany(mappedBy = "rider", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Result> results;

}

package grab.grabber.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

/**
 * Требуемы навыки в вакансии.
 * @see Vacancy
 * @author GitHub: alxkzncoff
 * @version 1.0
 * @since JDK 17
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "of")
@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Skill skill = (Skill) o;
        return id == skill.id && Objects.equals(name, skill.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

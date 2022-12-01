package grab.grabber.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Вакансия. Содержит базовую информацию:
 *  - Название;
 *  - Описание;
 *  - Компания;
 *  - Город;
 *  - Зарплата.
 * @see Skill
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
@Table(name = "vacancies")
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private String company;
    private String city;
    private String salary;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "vacancies_skills", joinColumns = {
            @JoinColumn(name = "vacancy_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
            @JoinColumn(name = "skill_id", nullable = false, updatable = false)})
    private Set<Skill> skills = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return id == vacancy.id && Objects.equals(description, vacancy.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}

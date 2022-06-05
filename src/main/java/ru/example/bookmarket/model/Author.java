package ru.example.bookmarket.model;

import lombok.*;
import ru.example.bookmarket.genries.Genre;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Builder
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres;

}

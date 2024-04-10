package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@NamedQueries({
        @NamedQuery(name = "Sponsor.findAll", query = "select a from Sponsor as a")
})
@Table(name = "SPONSOR")
@Getter @Setter
public class Sponsor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "sponsors")
    private List<Player> players = new ArrayList<>();

    public Sponsor() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return Objects.equals(id, sponsor.id) &&
                Objects.equals(name, sponsor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}


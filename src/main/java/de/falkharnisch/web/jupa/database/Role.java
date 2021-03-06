package de.falkharnisch.web.jupa.database;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ROLE_FUNCTION",
            joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "FUNCTION_ID", referencedColumnName = "ID")
    )
    private Set<Function> functions;

    public Integer getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public Set<Function> getFunctions() {
        return functions;
    }
}

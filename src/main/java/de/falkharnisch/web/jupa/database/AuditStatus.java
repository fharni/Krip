package de.falkharnisch.web.jupa.database;

import javax.persistence.*;

@Entity
@Table(name = "AUDIT_STATUS")
public class AuditStatus implements BaseEntity {

	private static final long serialVersionUID = 5623409645697138411L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String status;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return getStatus();
    }
}

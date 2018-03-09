package de.falkharnisch.web.jupa.services;

import de.falkharnisch.web.jupa.database.*;
import de.falkharnisch.web.jupa.producer.qualifier.ApplicationManaged;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class CourseService implements Serializable {

    @Inject
    @ApplicationManaged
    private EntityManager em;

    public List<Course> getCoursesForDistrict(@NotNull District district) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        Root<Course> course = query.from(Course.class);
        Join<Course, Club> clubJoin = course.join(Course_.club);
        query.where(builder.equal(clubJoin.get(Club_.district), district));
        return em.createQuery(query).getResultList();
    }
}
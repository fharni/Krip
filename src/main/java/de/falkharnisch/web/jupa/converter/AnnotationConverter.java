package de.falkharnisch.web.jupa.converter;

import de.falkharnisch.web.jupa.services.CourseService;
import org.slf4j.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

@Named
public class AnnotationConverter extends BaseConverter {

    @Inject
    private Logger logger;

    @Inject
    private CourseService courseService;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return courseService.getAnnotationByName(value);
            } catch (NoResultException e) {
                logger.info("Vermerk %s nicht gefunden", value, e);
            }
        }
        return null;
    }
}

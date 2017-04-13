package de.falkharnisch.web.karip.beans;


import de.falkharnisch.web.karip.constants.Roles;
import de.falkharnisch.web.karip.database.User;
import de.falkharnisch.web.karip.services.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.security.Principal;

/**
 * Managed Bean for handling with the user service.
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    @Inject
    private UserService userService;

    public User getCurrentUser() {
        if (isLoggedIn()) {
            String username = getUserPrinzipal().getName();
            return userService.getUserByUsername(username);
        }
        return null;
    }

    public boolean isLoggedIn() {
        return getUserPrinzipal() != null;
    }

    public boolean isUserAdmin() {
        return getExternalContext().isUserInRole(Roles.USERADMIN_ROLE);
    }

    private Principal getUserPrinzipal() {
        return getExternalContext().getUserPrincipal();
    }

    private ExternalContext getExternalContext() {
        FacesContext fc = FacesContext.getCurrentInstance();
        return fc.getExternalContext();
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login";
    }
}
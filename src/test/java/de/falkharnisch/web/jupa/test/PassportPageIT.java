package de.falkharnisch.web.jupa.test;

import de.falkharnisch.web.jupa.page.LoginPage;
import de.falkharnisch.web.jupa.page.MenuHeader;
import de.falkharnisch.web.jupa.page.PassportPage;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.testng.Arquillian;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(dependsOnGroups = "login")
public class PassportPageIT extends AbstractDroneTest {

    @Page
    private MenuHeader menuHeader;

    @Page
    private PassportPage passportPage;

    @Test(dataProvider = Arquillian.ARQUILLIAN_DATA_PROVIDER)
    public void testPassport(@InitialPage LoginPage loginPage) {
        loginPage.login("0502001000015", "falk");

        menuHeader.goToPassport();

        assertEquals(passportPage.getUsername(), "0502001000015", "Username doesn't match");
        assertEquals(passportPage.getName(), "Falk Harnisch", "Name doesn't match");
        assertEquals(passportPage.getClubName(), "TV 1875 Paderborn e.V.", "Clubname doesn't match");
        assertEquals(passportPage.getDistrictName(), "Bielefeld", "Districtname doesn't match");
        assertEquals(passportPage.getFederationName(), "Nordrhein-Westfalen", "Federationname doesn't match");
    }

}

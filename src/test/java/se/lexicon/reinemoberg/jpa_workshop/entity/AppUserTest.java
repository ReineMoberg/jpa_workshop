package se.lexicon.reinemoberg.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppUserTest {

    AppUser testAppUser;

    @BeforeEach
    public void setup(){
        testAppUser = new AppUser();
        testAppUser.setAppUserId(1);
        testAppUser.setFirstName("Reine");
        testAppUser.setLastName("Moberg");
        testAppUser.setEmail("mail.mail@gmail.com");
    }

    @Test
    @DisplayName("Create appUser object")
    public void testCreateAppUser() {
        Assertions.assertEquals(1, testAppUser.getAppUserId());
        Assertions.assertEquals("Reine", testAppUser.getFirstName());
        Assertions.assertEquals("Moberg", testAppUser.getLastName());
        Assertions.assertEquals("mail.mail@gmail.com", testAppUser.getEmail());
    }

    @Test
    @DisplayName("Equals method")
    public void testEqualsMethod() {
        AppUser expectedAppUser = new AppUser();
        expectedAppUser.setAppUserId(1);
        expectedAppUser.setFirstName("Reine");
        expectedAppUser.setLastName("Moberg");
        expectedAppUser.setEmail("mail.mail@gmail.com");
        Assertions.assertEquals(expectedAppUser, testAppUser);
    }

    @Test
    @DisplayName("Hash code method")
    public void testHashCode(){
        AppUser expectedAppUser = new AppUser();
        expectedAppUser.setAppUserId(1);
        expectedAppUser.setFirstName("Reine");
        expectedAppUser.setLastName("Moberg");
        expectedAppUser.setEmail("mail.mail@gmail.com");
        Assertions.assertEquals(expectedAppUser.hashCode(), testAppUser.hashCode());
    }

    @Test
    @DisplayName("To string method")
    public void testToString() {
        System.out.println(testAppUser.toString());
    }
}

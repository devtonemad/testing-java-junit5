package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void testPerson() {
        Person person = new Person(1L, "Joe", "Banana");
        assertAll("TestFirstName",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Banana", person.getLastName()));
    }

}
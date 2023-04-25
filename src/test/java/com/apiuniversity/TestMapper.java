package com.apiuniversity;

import com.apiuniversity.entity.TypeIdentification;
import com.apiuniversity.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMapper {

    @Test
    void mapperTest() {
        User user = new User();
        TypeIdentification type = new TypeIdentification
                (1L,
                        "Cédula de Ciudadanía'",
                        "La cédula de ciudadanía es el documento de identificación de los ciudadanos colombianos mayores de 18 años.",
                        true);

        user.setLastName("Ramirez");
        user.setFirstName("Yeison");
        user.setTypeIdentification(type);
    }
}

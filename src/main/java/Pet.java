import lombok.Data;

import java.time.LocalDate;

@Data
public class Pet {
    String id;
    String name;
    String type;
    String sex;
    String breed;
    String age;
    String weight;
    String color;
    LocalDate intakeDate;
    String location;
    String image;
}

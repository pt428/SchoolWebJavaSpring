package cz.tichy.moje.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "student")
@Getter
@Setter
public class StudentEntity {
    @Id//primarni klic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;

}

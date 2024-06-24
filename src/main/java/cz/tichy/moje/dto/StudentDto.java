package cz.tichy.moje.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
      Integer id;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;

}

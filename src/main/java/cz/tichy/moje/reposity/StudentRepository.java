package cz.tichy.moje.reposity;

import cz.tichy.moje.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {


}

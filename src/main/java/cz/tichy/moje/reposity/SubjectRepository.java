package cz.tichy.moje.reposity;

import cz.tichy.moje.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository  extends JpaRepository<SubjectEntity,Integer> {

}

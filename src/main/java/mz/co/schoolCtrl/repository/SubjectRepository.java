package mz.co.schoolCtrl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mz.co.schoolCtrl.model.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {


}

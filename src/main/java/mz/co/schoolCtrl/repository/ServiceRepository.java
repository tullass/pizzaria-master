package mz.co.schoolCtrl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mz.co.schoolCtrl.model.Servicee;

@Repository
public interface ServiceRepository extends CrudRepository<Servicee, Long> {


}

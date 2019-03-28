package mz.co.schoolCtrl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mz.co.schoolCtrl.model.Teste;

@Repository
public interface TesteRepository extends CrudRepository<Teste, Long> {


}

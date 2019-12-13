package org.launchcode.dismissal1.models.data;

import org.launchcode.dismissal1.models.changetransportation;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ChangetransportationDao extends CrudRepository<changetransportation,Integer> {

}

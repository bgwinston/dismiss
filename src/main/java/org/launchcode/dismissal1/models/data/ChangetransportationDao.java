package org.launchcode.dismissal1.models.data;

import org.launchcode.dismissal1.models.changetransportation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

    @Transactional
    @Repository
    public interface ChangetransportationDao extends CrudRepository<changetransportation,Integer> {

}

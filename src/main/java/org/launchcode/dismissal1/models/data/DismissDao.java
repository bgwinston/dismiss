package org.launchcode.dismissal1.models.data;
//Interact with the database

import org.launchcode.dismissal1.models.dismiss;
import org.springframework.data.repository.CrudRepository;

//Database will store Dismiss objects and dismiss objects have integer id's
public interface DismissDao extends CrudRepository<dismiss,Integer> {
}

package org.launchcode.dismissal1.models.data;
//Interact with the database

import org.launchcode.dismissal1.models.user;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
//Database will store Dismiss objects and dismiss objects have integer id's
public interface UserDao extends CrudRepository<user,Integer> {

    user findByUsername (String username);
   //user findByPassword (String password);


}

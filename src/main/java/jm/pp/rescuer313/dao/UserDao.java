package jm.pp.rescuer313.dao;

import jm.pp.rescuer313.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByLogin(String login);
}

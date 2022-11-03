package FreezyAce.Spring_312.dao;

import FreezyAce.Spring_312.model.User;

import java.util.List;

public interface DaoUser {
    User userById(long id);

    List<User> getUser();

    void save(User user);

    void deleteUser(long id);

    void update(long id, User updateUser);
}

package FreezyAce.Spring_312.dao;

import FreezyAce.Spring_312.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DaoUserImpl implements DaoUser {

    @PersistenceContext
    private EntityManager entityManager;

    public User userById(long id){
        return entityManager.find(User.class, id);
    }

    public List<User> getUser() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    public void save(User user) {
        System.out.println(user.toString());
        entityManager.persist(user);
    }

    public void deleteUser(long id) {
       entityManager.remove(userById(id));
    }

    public void update(long id, User updateUser) {
        User userUpdated = userById(id);

        userUpdated.setUsername(updateUser.getUsername());
        userUpdated.setLastName(updateUser.getLastName());
        userUpdated.setEmail(updateUser.getEmail());
        userUpdated.setAge(updateUser.getAge());
        userUpdated.setPassword(updateUser.getPassword());
    }

}

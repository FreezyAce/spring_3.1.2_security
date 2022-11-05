package FreezyAce.Spring_312.service;

import FreezyAce.Spring_312.model.User;
import FreezyAce.Spring_312.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User userById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void update(long id, User updateUser) {
        User userUpdated = userById(id);

        userUpdated.setUsername(updateUser.getUsername());
        userUpdated.setLastName(updateUser.getLastName());
        userUpdated.setEmail(updateUser.getEmail());
        userUpdated.setAge(updateUser.getAge());
        userUpdated.setPassword(passwordEncoder.encode(updateUser.getPassword()));
        userUpdated.setRole(updateUser.getRole());
    }

}

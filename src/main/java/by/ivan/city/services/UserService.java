package by.ivan.city.services;

import by.ivan.city.models.User;
import by.ivan.city.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    public final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User getUser(long id) {
        Optional<User>  findUser =  userRepository.findById(id);
        return findUser.orElse(null);
    }
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }

}

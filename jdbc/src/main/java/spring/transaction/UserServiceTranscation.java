package spring.transaction;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring.User;

import java.util.List;

@Transactional( propagation = Propagation.REQUIRED )
public interface UserServiceTranscation {
    public void save(User user);

    public void saveException(User user) throws Exception;

    public List<User> getUsers();
}

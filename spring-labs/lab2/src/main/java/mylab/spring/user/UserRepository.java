package mylab.spring.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {
    @Value("MySQL")
    private String dbType;

    private List<String> users = new ArrayList<String>();

    public String getDbType() {
        return dbType;
    }

    public void save(String username) {
        users.add(username);
    }

    public List<String> getUsernames() {
        return users;
    }
}

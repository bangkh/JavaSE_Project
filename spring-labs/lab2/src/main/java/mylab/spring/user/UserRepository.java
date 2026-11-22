package mylab.spring.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {
    @Value("MySQL")
    private String dbType;

    private final List<String> usernames = new ArrayList<String>();

    public String getDbType() { return dbType; }

    public void save(String username) {
        usernames.add(username);
    }

    public List<String> getUsernames() {
        return Collections.unmodifiableList(new ArrayList<String>(usernames));
    }
}
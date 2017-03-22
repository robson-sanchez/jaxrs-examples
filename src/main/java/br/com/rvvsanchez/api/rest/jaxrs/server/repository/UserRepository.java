package br.com.rvvsanchez.api.rest.jaxrs.server.repository;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import br.com.rvvsanchez.api.rest.jaxrs.server.model.User;

@Configuration
@ConfigurationProperties
public class UserRepository {

  private List<User> users;

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }
  
  public User addUser(User user) {
    Long id = Long.valueOf(users.size()) + 1;
    user.setId(id);
    
    this.users.add(user);
    
    return user;
  }
  
  public User getUserById(Long id) {
    return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
  }
  
}

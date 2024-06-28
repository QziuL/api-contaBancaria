package br.qziul.restful.Service;

import br.qziul.restful.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User create(User user);
    User deleteById(Long id);
}

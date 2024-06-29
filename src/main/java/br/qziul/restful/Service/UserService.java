package br.qziul.restful.Service;

import br.qziul.restful.dto.UserDTO;
import br.qziul.restful.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User create(UserDTO userDTO);
    User deleteById(Long id);
}

package br.qziul.restful.Service.impl;

import br.qziul.restful.Service.UserService;
import br.qziul.restful.model.User;
import br.qziul.restful.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if(Objects.isNull(user))
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        if(userRepository.existsById(user.getId()))
            throw new IllegalArgumentException("Usuário já existente.");
        if(userRepository.existsByAccountNumber(user.getAccount().getNumber()))
            throw new IllegalArgumentException("Número da conta já existente.");
        return userRepository.save(user);
    }

    @Override
    public boolean deleteById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

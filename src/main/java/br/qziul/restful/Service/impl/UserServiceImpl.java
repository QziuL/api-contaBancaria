package br.qziul.restful.Service.impl;

import br.qziul.restful.Service.UserService;
import br.qziul.restful.dto.CardDTO;
import br.qziul.restful.dto.UserDTO;
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
    public User create(UserDTO userDTO) {
        if(Objects.isNull(userDTO))
            throw new IllegalArgumentException("Usuário nulo.");
        if(userRepository.existsByAccountNumber(userDTO.getAccount().getNumber()))
            throw new IllegalArgumentException("Número da conta existente.");
        if(userRepository.existsByCardNumber(userDTO.getCard().getNumber()))
            throw new IllegalArgumentException("Número do cartão existente.");
        return userRepository.save(userDTO.convertToUser());
    }

    @Override
    public User deleteById(Long id) {
        User user = findById(id);
        userRepository.deleteById(id);
        return user;
    }
}

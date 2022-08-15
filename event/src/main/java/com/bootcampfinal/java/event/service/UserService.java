package com.bootcampfinal.java.event.service;

import com.bootcampfinal.java.event.domain.User;
import com.bootcampfinal.java.event.repository.UserRepository;
import com.bootcampfinal.java.event.service.mapper.UserMapper;
import com.bootcampfinal.java.event.web.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserModel login(String email, String password) throws Exception {
        Optional<User> user = userRepository.findByEmailIgnoreCaseAndPasswordIgnoreCase(email,password);
        if(user.isPresent()) return userMapper.userToUserModel(user.get());
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public List<UserModel> findAll()  throws Exception {
        List<User> users = userRepository.findAll();
        return userMapper.usersToUserModels(users);
    }


    @Override
    public UserModel findById(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) return userMapper.userToUserModel(user.get());
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public UserModel create(UserModel userModel)  throws Exception{
        User event = userRepository.save(userMapper.userModelToUser(userModel));
        return userMapper.userToUserModel(event);
    }

    @Override
    public void update(Long id, UserModel userModel)  throws Exception {
        Optional<User> eventOptional = userRepository.findById(id);

        if(eventOptional.isPresent()) {
            User userToUpdate = eventOptional.get();
            userMapper.update(userToUpdate, userModel);
            userRepository.save(userToUpdate);
        }
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public void deleteById(Long id)  throws Exception {
        userRepository.deleteById(id);
    }

}
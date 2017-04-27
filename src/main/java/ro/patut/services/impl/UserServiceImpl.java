package ro.patut.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.patut.models.UserModel;
import ro.patut.repository.UserRepository;
import ro.patut.services.UserService;

import java.util.*;

/**
 * Created by neop on 08.04.2017.
 */

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(UserModel userModel) {
        userRepository.save(userModel);
    }

    @Override
    public List<UserModel> getAllUsersAsList() {
        List<UserModel> userModelList=new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(userModelList::add);
        return userModelList;
    }

    @Override
    public UserModel getUserByNickName(String nickname) {
        logger.debug("UserService.getUserByNickName called successfully");
        return userRepository.findByNickname(nickname);
    }

    @Override
    public void updateUser(UserModel userModel) {
        userRepository.save(userModel);
    }

    //TODO:  need properly implementation
    @Override
    public void deleteUser(String nickname) {
        userRepository.delete(new UserModel());
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public UserModel findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

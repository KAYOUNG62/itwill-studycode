package edu.web.jsp02.service;

import java.util.List;

import edu.web.jsp02.domain.User;
import edu.web.jsp02.dto.UserSignUpDto;
import edu.web.jsp02.dto.UserUpdateDto;
import edu.web.jsp02.repository.UserDao;
import edu.web.jsp02.repository.UserDaoImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private static UserServiceImpl instance = null;
    private UserServiceImpl() {
        userDao = UserDaoImpl.getInstance();
    }
    public static UserServiceImpl getInstance() {
        if(instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }
    
    @Override
    public List<User> read() {
        log.info("read()");
        return userDao.select();
    }

    @Override
    public int signUp(UserSignUpDto dto) {
        log.info("create(dto={})", dto);
        return userDao.insert(dto.toEntity());
    }
    
    @Override
    public User signIn(String username, String password) {
        log.info("signIn(username={}, password={}", username, password);
        User user = User.builder().username(username).password(password).build();
        return userDao.selectByUsernameAndPassword(user);
    }

    @Override
    public User readById(Integer id) {
        log.info("readById(id={})",id);
        return userDao.select(id);
    }

    @Override
    public int delete(Integer id) {
        log.info("delete(id={})",id);
        return userDao.delete(id);
    }

    @Override
    public int update(UserUpdateDto dto) {
        log.info("update(dto={})",dto);
        return userDao.update(dto.toEntity());
    }

}

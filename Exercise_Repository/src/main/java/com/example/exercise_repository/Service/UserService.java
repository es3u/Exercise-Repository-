package com.example.exercise_repository.Service;

import com.example.exercise_repository.ApiResponse.ApiException;
import com.example.exercise_repository.Model.User;
import com.example.exercise_repository.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        List list = userRepository.findAll();
        if(list.isEmpty()){
            throw new ApiException("list is empty");
        }
        return list;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id ,User user) {
        User oldUser = userRepository.findUById(id);
        if(oldUser == null){
            throw new ApiException("user not found");
        }
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setAge(user.getAge());
        oldUser.setAge(user.getAge());
        userRepository.save(oldUser);
    }

    public void deleteUser(Integer id) {


        if(userRepository.findUById(id) == null){
            throw new ApiException("user not found");
        }
        userRepository.deleteById(id);
    }

    public User findByPasswordAndUsername(String password, String username) {
        User user = userRepository.findUserByPasswordAndUserName(password, username);


        if(user == null){
            throw new ApiException("user not found");
        }
        return user;
    }





    public User findByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        if(user == null){
            throw new ApiException("user not found");
        }
        return user;
    }

    public List findByRole(String role) {
        List list = userRepository.findUserByRole(role);
        if(list.isEmpty()){
            throw new ApiException("list is empty");
        }
        return list;
    }

    public List findRang(Integer min , Integer max) {
        List list = userRepository.findUserByRaang(min, max);
        if(list.isEmpty()){
            throw new ApiException("list is empty");
        }
        return list;
    }







 }

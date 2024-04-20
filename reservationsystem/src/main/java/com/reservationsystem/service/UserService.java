package com.reservationsystem.service;

import java.util.List;
import java.util.Optional;

import com.reservationsystem.dto.UserDto;
import com.reservationsystem.entity.User;


public interface UserService {

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);

	Optional<User> findUserByEmail(String email);

}

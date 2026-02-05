package com.rasheen.practice.service;

import com.rasheen.practice.dto.UserDto;
import com.rasheen.practice.entity.User;
import com.rasheen.practice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    public UserDto create(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        User saved = userRepository.save(user);

        dto.setId(saved.getId());
        return dto;
    }

    // READ ALL
    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> {
                    UserDto dto = new UserDto();
                    dto.setId(user.getId());
                    dto.setName(user.getName());
                    dto.setEmail(user.getEmail());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // READ BY ID
    public UserDto getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    // UPDATE
    public UserDto update(Long id, UserDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        userRepository.save(user);
        return dto;
    }

    // DELETE
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    // PAGINATION
    public Page<UserDto> getUsersPaged(int page, int size, String sortBy) {

    PageRequest pageable = PageRequest.of(
            page,
            size,
            Sort.by(sortBy)
    );

    return userRepository.findAll(pageable)
            .map(user -> {
                UserDto dto = new UserDto();
                dto.setId(user.getId());
                dto.setName(user.getName());
                dto.setEmail(user.getEmail());
                return dto;
            });
}

}

package com.microservice.userService.Service;

import com.microservice.userService.Entity.Users;
import com.microservice.userService.Repository.UserRepository;
import com.microservice.userService.VO.Department;
import com.microservice.userService.VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Users saveUser(Users user) {
        log.info("in side service saveUser");
        return userRepository.save(user);
    }

  public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("in side service getUserWithDepartment");
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        Users user = userRepository.findByUserId (userId);
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),
                        Department.class);
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }
}

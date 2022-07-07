package com.microservice.userService.Controller;

import com.microservice.userService.Entity.Users;
import com.microservice.userService.Service.UserService;
import com.microservice.userService.VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public Users saveUser(@RequestBody Users user){
       log.info("in side controller saveUser");
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("in side controller getUserWithDepartment");
        return userService.getUserWithDepartment(userId);
    }

}

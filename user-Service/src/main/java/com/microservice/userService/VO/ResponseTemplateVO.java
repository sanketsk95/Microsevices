package com.microservice.userService.VO;

import com.microservice.userService.Entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseTemplateVO {

    private Users user;
    private Department department;
}

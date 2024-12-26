package com.example.mimi.il.dto;

import com.example.mimi.il.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInsertReqDTO {
    private String userName;
    private String email;
    private String password;
    private String phoneNum;
}

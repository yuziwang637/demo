package com.example.laboratory.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "登录请求参数")
public class LoginRequest {
    @Schema(description = "学号", example = "2024001", required = true)
    private String studentId;
    
    @Schema(description = "密码", example = "123456", required = true)
    private String password;
}
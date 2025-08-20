package com.example.laboratory.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "管理员登录请求参数")
public class AdminLoginRequest {
    @Schema(description = "用户名", example = "admin", required = true)
    private String username;
    
    @Schema(description = "密码", example = "admin123", required = true)
    private String password;
}
package com.example.laboratory.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "修改密码请求参数")
public class ChangePasswordRequest {
    @Schema(description = "用户ID", example = "1", required = true)
    private Long id;
    
    @Schema(description = "原密码", example = "old123456", required = true)
    private String oldPassword;
    
    @Schema(description = "新密码", example = "new123456", required = true)
    private String newPassword;
}
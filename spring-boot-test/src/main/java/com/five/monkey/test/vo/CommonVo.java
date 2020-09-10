package com.five.monkey.test.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * swagger测试接口返参
 *
 * @author jim
 * @date 2020/9/10 12:14
 */
@ApiModel("swagger测试接口返参")
@Data
public class CommonVo {

    @ApiModelProperty(value = "id主键", position = 0)
    private Long id;

    @ApiModelProperty(value = "姓名", position = 1)
    private String name;

    @ApiModelProperty(value = "邮箱", position = 2)
    private String email;

    @ApiModelProperty(value = "手机号", position = 3)
    private String phone;

    @ApiModelProperty(value = "请求方式", position = 4)
    private String requestMethod;
}

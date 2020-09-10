package com.five.monkey.test.cmd;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * swagger测试接口入参
 *
 * @author jim
 * @date 2020/9/10 12:20
 */
@Data
@ApiModel("swagger测试接口入参")
public class CommonCmd {

    @ApiModelProperty(name = "id", value = "authord的id", required = true, dataType = "Long", position = 0)
    private Long id;

    @ApiModelProperty(name = "name", value = "author的name", required = true, dataType = "String", position = 1)
    private String name;
}

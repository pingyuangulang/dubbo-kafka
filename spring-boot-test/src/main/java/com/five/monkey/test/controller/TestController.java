package com.five.monkey.test.controller;

import com.five.monkey.test.cmd.CommonCmd;
import com.five.monkey.test.vo.CommonVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author jim
 * @date 2020/9/10 12:11
 */
@Api(tags = {"test控制器"})
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * swagger-get test
     *
     * @param id
     * @param name
     * @return
     */
    @ApiOperation(value = "swagger-get测试接口", response = CommonVo.class, httpMethod = "GET")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "author的id", required = true, paramType = "path", dataType = "Long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "name", value = "author的name", required = true, paramType = "query", dataType = "String", dataTypeClass = String.class)
    })
    @GetMapping("/swagger/test/{id}")
    public CommonVo swaggerTest(@PathVariable("id") Long id, @RequestParam(value = "name") String name) {

        CommonVo vo = new CommonVo();
        vo.setId(id);
        vo.setName(name);
        vo.setEmail("abc@163.com");
        vo.setPhone("17930548509");
        vo.setRequestMethod("GET");
        return vo;
    }

    /**
     * swagger-post test
     *
     * @param commonCmd
     * @return
     */
    @ApiOperation(value = "swagger-post测试接口", response = CommonVo.class, httpMethod = "POST")
    @PostMapping("/swagger/test/post")
    public CommonVo swaggerTestPost(@RequestBody CommonCmd commonCmd) {
        CommonVo vo = new CommonVo();
        vo.setId(commonCmd.getId());
        vo.setName(commonCmd.getName());
        vo.setEmail("def@qq.com");
        vo.setPhone("15670623851");
        vo.setRequestMethod("POST");
        return vo;
    }
}

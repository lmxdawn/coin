package com.coin.user.controller;

import com.coin.dubbo.service.EchoService;
import com.coin.user.res.BaseResponse;
import com.coin.user.res.EchoResponse;
import com.coin.user.util.ResultVOUtils;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试接口")
@RestController
public class EchoController {

    @DubboReference
    private EchoService echoService;

    @ApiOperation(value = "打印信息", notes = "打印信息出来")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "str", value = "需要打印的字符", dataType = "string", paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "success", response = EchoResponse.class),
            @ApiResponse(code = 401, message = "xxx具体错误")
    })
    @GetMapping("/echo/{str}")
    public BaseResponse<EchoResponse> echo(@PathVariable String str) {
        EchoResponse echoResponse = new EchoResponse();
        echoResponse.setStr(echoService.echo(str));
        return ResultVOUtils.success(echoResponse);
    }

}

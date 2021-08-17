package com.coin.wallet.dubbo.service;

import com.coin.dubbo.service.EchoService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String message) {
        return "Echo " + message;
    }
}

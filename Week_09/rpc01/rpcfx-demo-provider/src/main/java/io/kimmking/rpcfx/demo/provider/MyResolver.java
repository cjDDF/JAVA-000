package io.kimmking.rpcfx.demo.provider;

import io.kimmking.rpcfx.api.RpcfxResolver;

import java.util.HashMap;
import java.util.Map;

public class MyResolver implements RpcfxResolver {
    private static Map<String, Object> map = new HashMap<>();
    static {
        map.put("io.kimmking.rpcfx.demo.api.OrderService", new OrderServiceImpl());
        map.put("io.kimmking.rpcfx.demo.api.UserService", new UserServiceImpl());
    }
    @Override
    public Object resolve(String serviceClass) {
        return map.get(serviceClass);
    }
}

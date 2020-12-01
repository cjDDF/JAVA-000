package com.ddf.separate.datasource;

import com.ddf.separate.anno.CurDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 多数据源，切面处理类
 *
 * @author xiaohe
 * @version V1.0.0
 */
@Slf4j
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    private static int count = 0;

    @Value("${slave.hosts}")
    private String[] slaves;

    @Pointcut("@annotation(com.ddf.separate.anno.CurDataSource)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        CurDataSource ds = method.getAnnotation(CurDataSource.class);
        if (ds == null) {
            DynamicDataSource.setDataSource(DataSourceNames.MASTER);
            log.debug("set datasource is " + DataSourceNames.MASTER);
        } else {
            String datasourceName = ds.name();
            if (datasourceName.equals(DataSourceNames.SLAVE)) {
                datasourceName = slaveLoadBalance();
            }
            DynamicDataSource.setDataSource(datasourceName);
            log.debug("set datasource is " + datasourceName);
        }

        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            log.debug("clean datasource");
        }
    }

    /**
     * 负载均衡
     */
    private String slaveLoadBalance() {
        //轮询
        if (count == slaves.length) {
            count=0;
        }
        return slaves[count++];
    }

    @Override
    public int getOrder() {
        return 1;
    }
}


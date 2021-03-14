package com.niuh.anno;

import com.niuh.core.RemoteCallBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启AngleRemoteCall rpc调用功能
 * Created by hejianhui on 2020/4/2.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(RemoteCallBeanDefinitionRegistrar.class)
public @interface EnableRemoteCall {

    /**
     * 扫描的路径
     * @return
     */
    String[] scannerPackages() default {};
}

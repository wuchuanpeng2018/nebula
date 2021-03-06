package io.nebula.messaging.annotation;

import java.lang.annotation.*;

/**
 * @author 徐步龙
 * @version V1.0
 * @date 2019/1/7
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Producer {
    /**
     * 消息队列的服务器地址
     * 如果没有设置，则使用全局设置
     *
     * @return
     */
    String serverUrl() default "";

    /**
     * 生产者组名
     * 如果没有设置，则使用全局设置
     *
     * @return
     */
    String group() default "";

    /**
     * 队列名
     *
     * @return
     */
    String topic();

    /**
     * 队列Tag
     *
     * @return
     */
    String tag() default "";
}

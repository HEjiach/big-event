package com.itheima.anno;

import com.itheima.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Documented//原注解
@Target(ElementType.FIELD)//源注解
@Retention(RetentionPolicy.RUNTIME)//源注解
@Constraint(validatedBy = {StateValidation.class})
public @interface State {
    //提供失败后提醒的信息
    String message() default "state参数的值只能是已发布||草稿";
    //指定分组
    Class<?>[] groups() default { };
    //负载state注解附加信息
    Class<? extends Payload>[] payload() default { };
}

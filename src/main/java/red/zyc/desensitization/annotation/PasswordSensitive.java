package red.zyc.desensitization.annotation;

import red.zyc.desensitization.desensitizer.Desensitizer;
import red.zyc.desensitization.desensitizer.PasswordDesensitizer;

import java.lang.annotation.*;

/**
 * 密码敏感标记注解。默认的脱敏规则：擦除目标对象中所有的字符。
 *
 * @author zyc
 */
@Target({ElementType.FIELD, ElementType.TYPE_USE, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Sensitive
public @interface PasswordSensitive {

    /**
     * @return 处理被 {@link PasswordSensitive}注解的字段脱敏器，注意密码字段类型可能为其它任何类型，
     * 所以此处的脱敏器支持的类型并没有作限制，可以自定义子类重写默认的处理逻辑
     */
    Class<? extends Desensitizer<?, PasswordSensitive>> desensitizer() default PasswordDesensitizer.class;

    /**
     * @return 敏感信息在原字符序列中的起始偏移
     */
    int startOffset() default 0;

    /**
     * @return 敏感信息在原字符序列中的结束偏移
     */
    int endOffset() default 0;

    /**
     * @return 正则表达式匹配的敏感信息，如果regexp不为{@code ""}的话则会
     * 忽略{@link PasswordSensitive#startOffset()}和{@link PasswordSensitive#endOffset()}的值
     */
    String regexp() default "";

    /**
     * @return 敏感信息替换后的占位符
     */
    char placeholder() default '*';
}

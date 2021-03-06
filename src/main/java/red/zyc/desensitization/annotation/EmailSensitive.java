/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package red.zyc.desensitization.annotation;

import red.zyc.desensitization.desensitizer.Desensitizer;
import red.zyc.desensitization.desensitizer.EmailDesensitizer;

import java.lang.annotation.*;

/**
 * 邮箱敏感标记注解。默认的脱敏规则：擦除目标对象中第二个字符与@符号间的所有字符，例如123456@qq.com脱敏后的值为1*****@qq.com
 *
 * @author zyc
 */
@Target({ElementType.FIELD, ElementType.TYPE_USE, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Sensitive
public @interface EmailSensitive {

    /**
     * @return 处理被 {@link EmailSensitive}注解的字段脱敏器，可以自定义子类重写默认的处理逻辑。
     */
    Class<? extends Desensitizer<CharSequence, EmailSensitive>> desensitizer() default EmailDesensitizer.class;

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
     * 忽略{@link EmailSensitive#startOffset()}和{@link EmailSensitive#endOffset()}的值
     */
    String regexp() default "(?<=.).*(?=@)";

    /**
     * @return 敏感信息替换后的占位符
     */
    char placeholder() default '*';
}

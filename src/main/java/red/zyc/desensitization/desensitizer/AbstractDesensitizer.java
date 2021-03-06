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
package red.zyc.desensitization.desensitizer;

import red.zyc.desensitization.util.ReflectionUtil;

import java.lang.annotation.Annotation;

/**
 * 脱敏器基类，为子类提供了一些快捷有用的方法处理敏感信息。
 *
 * @param <A> 实现类要处理的注解类型
 * @param <T> 实现类支持的处理类型
 * @author zyc
 */
public abstract class AbstractDesensitizer<T, A extends Annotation> implements Desensitizer<T, A> {

    /**
     * 敏感信息处理注解支持的目标{@code Class}
     */
    protected Class<T> supportedClass;
    /**
     * 敏感信息处理注解的{@code Class}
     */
    protected Class<A> annotationClass;

    @SuppressWarnings("unchecked")
    public AbstractDesensitizer() {
        Class<?>[] actualTypeArgumentsOfSensitiveHandler = Desensitizer.getActualTypeArgumentsOfDesensitizer(ReflectionUtil.getClass(this));
        supportedClass = (Class<T>) actualTypeArgumentsOfSensitiveHandler[0];
        annotationClass = (Class<A>) actualTypeArgumentsOfSensitiveHandler[1];
    }
}

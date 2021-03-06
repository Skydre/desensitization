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
package red.zyc.desensitization.util.caller;

/**
 * @author zyc
 */
public interface Caller {

    /**
     * 获取调用当前方法对象的{@code Class}
     *
     * @return 调用当前方法对象的 {@code Class}
     */
    Class<?> getCaller();

    /**
     * 获取调用指定堆栈深度所在的对象的{@code Class}。例如当前堆栈深度为1，2则是调用当前方法所在的堆栈深度。
     *
     * @param depth 调用堆栈深度
     * @return 调用指定堆栈深度所在的对象的 {@code Class}
     */
    Class<?> getCaller(int depth);

    /**
     * 打印执行堆栈
     */
    void printStackTrace();
}

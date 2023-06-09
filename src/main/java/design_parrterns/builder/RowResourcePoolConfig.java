/*
package design_parrterns.builder;

import org.junit.platform.commons.util.StringUtils;

*/
/**
 * 原始的资源池配置类，其中有个成员变量（可配置项）
 *
 * @author yao 2022/11/11
 *//*

public class RowResourcePoolConfig {

    // 最大总资源数量
    private static final int DEFAULT_MAX_SIZE=8;
    // 最大空闲资源数量
    private static final int DEFAULT_MAX_IDLE = 8;
    // 最小空闲资源数量
    private static final int DEFAULT_MIN_IDLE = 0;
    // 资源名称
    private String name;

    private int maxSize = DEFAULT_MAX_SIZE;
    private int maxIdle = DEFAULT_MAX_IDLE;
    private int minIdle = DEFAULT_MIN_IDLE;

    */
/**
     * 但是若是参数数量变多，参数列表就会很长，而且可能由于参数顺序导致错误
     * 解决方法之一是提供set函数
     *//*

    public RowResourcePoolConfig(String name, int maxSize, int maxIdle, int minIdle) {
        if(StringUtils.isBlank(name)) throw new IllegalArgumentException("name should not be empty!");
        this.name = name;
        if(maxSize<=0) throw new IllegalArgumentException("maxSize should be positive");
        this.maxSize = maxSize;
        if (maxIdle<0) throw new IllegalArgumentException("maxIdle should not be negative");
        this.maxIdle = maxIdle;
        if(minIdle<0) throw new IllegalArgumentException("minIdle should not be negative");
        this.minIdle = minIdle;
    }

    public RowResourcePoolConfig(String name) {
        if(StringUtils.isBlank(name)) throw new IllegalArgumentException("name should not be empty!");
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    */
/*
      https://blog.csdn.net/zhizhengguan/article/details/122281430
      但是这样做仍然有问题

      1. 如果没有默认值的必要参数（比如name）过多，还是会出现构造参数列表过长的问题
      如果把必填项放到set中，那校验这些必填项写没写的逻辑就无处安放

      2. 如果配置项有一定的依赖关系或者相互约束，配置项之间的逻辑校验也没地方放写

      3. 如果对象是不可变对象，就不应该提供set方法
     *//*

}
*/

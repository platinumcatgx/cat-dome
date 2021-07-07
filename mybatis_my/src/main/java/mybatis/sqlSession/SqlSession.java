package mybatis.sqlSession;

import java.util.List;

/**
 * 自定义mybatis中 和数据库交互的核心类
 * 它可以创建 dao 接口的代理对象
 */
public interface SqlSession {

    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源的方法
     */
    void close();

    /**
     *
     * @param list
     * @return
     */
    List selectList(String list);

}

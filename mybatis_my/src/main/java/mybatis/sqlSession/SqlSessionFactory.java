package mybatis.sqlSession;

public interface SqlSessionFactory {

    /**
     * 用于打开一个Session对象
     * @return
     */
    SqlSession openSession();
}

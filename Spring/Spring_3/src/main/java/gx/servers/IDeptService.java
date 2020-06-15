package gx.servers;

import gx.domain.Dept;

import java.util.List;

/**
 * service层
 */
public interface IDeptService {

    List<Dept> findAllDept();

}

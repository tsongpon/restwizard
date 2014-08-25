package repository;

import domain.Employee;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import resourcemapper.EmployeeJdbiMapper;

import java.util.List;

/**
 *
 */
@RegisterMapper(EmployeeJdbiMapper.class)
public interface EmlooyeeRepository {

    @SqlQuery("select id,name,title,age from employee limit 10")
    public List<Employee> list();

    @SqlQuery("select id,name,title,age from employee where id = :it")
    public Employee getById(@Bind long id);
}

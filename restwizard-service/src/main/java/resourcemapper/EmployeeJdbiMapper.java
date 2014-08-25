package resourcemapper;


import domain.Employee;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import transport.EmployeeTransport;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class EmployeeJdbiMapper implements ResultSetMapper<Employee> {
    @Override
    public Employee map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Employee(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("title"), resultSet.getInt("age"));
    }
}

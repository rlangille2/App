package assembler;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Assembler<T> {

	public T convert(ResultSet resultSet) throws SQLException;

}
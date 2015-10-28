package org.gitmining.dao.impl;

import org.gitmining.bean.Employee;
import org.gitmining.dao.EmployeeDao;

public class EmployeeDaoImpl extends BaseDaoImpl implements EmployeeDao {

	public boolean insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return sqlSession.insert("employee.insertEmployee", employee) == 1 ? true: false;
	}

}

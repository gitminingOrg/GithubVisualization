package org.gitmining.dao;

import org.gitmining.bean.Employee;

public interface EmployeeDao {
	/**
	 * 新增员工
	 * @param employee
	 * @return
	 */
	public boolean insertEmployee(Employee employee);
}

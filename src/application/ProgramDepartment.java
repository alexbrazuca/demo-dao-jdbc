package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDepartment {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.creatDepartmentDao();
		System.out.println("=== TEST 1: Department findById =====");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
	}

}

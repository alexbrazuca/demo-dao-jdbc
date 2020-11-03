package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDepartment {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.creatDepartmentDao();
		System.out.println("=== TEST 1: Department findById =====");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: Department findAll =====");
		List<Department> list = departmentDao.findAll();
		for (Department department : list) {
			System.out.println(department);
		}
		
		System.out.println("\n=== TEST 4: Department insert =====");
		Department department = new Department(null,"Massas");
		//departmentDao.insert(department);
		//System.out.println("Inserted! New id = " + department.getId());
		
		System.out.println("\n=== TEST 5: Department update =====");
		Department dep1 = new Department();
		dep1 = departmentDao.findById(6);
		dep1.setName("Carnes");
		departmentDao.update(dep1);
		System.out.println(dep1);
	
		System.out.println("\n=== TEST 6: Department delete by id =====");
		departmentDao.deleteById(6);
		for (Department departmen : list) {
			System.out.println(departmen);
		}
		
		
	}

}

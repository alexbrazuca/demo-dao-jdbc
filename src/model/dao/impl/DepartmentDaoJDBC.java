package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
	
	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {


	}

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
		st = conn.prepareStatement(
				"SELECT * FROM department "
				+ "WHERE department.Id = ? ");
		st.setInt(1, id);
		rs = st.executeQuery();
		if(rs.next()) {
			Department dep = new Department();
			dep.setId(rs.getInt(1));
			dep.setName(rs.getString(2));
			return dep;
			}
		
		return null;
		
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}
	
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("Id"));
		dep.setName(rs.getString("Name"));
		return dep;
	}

	@Override
	public List<Department> findAll() {
	
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT * FROM department as department");
			rs = st.executeQuery();
			List<Department> list = new ArrayList<>();
			Map<Integer, Department>map = new HashMap<>();
			while(rs.next()) {
				Department dep = map.get(rs.getInt("Id"));
				if(dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("Id"), dep);
				}
				
				Department obj = instantiateDepartment(rs);
				list.add(obj);
				
				}
			return list;
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}
}

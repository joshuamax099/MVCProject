package com.lti.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.lti.model.Login;
import com.lti.model.Registration;


public class JdbcDao {
	@Autowired
	JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	public void savedata(Registration r)
	{
		String sql= "insert into group2_registration(?,?,?,?,?,?,?,?,?)";
		jdbctemplate.update(sql, new Object[] {r.getName(), r.getAge(),r.getUname(), r.getPass(), r.getAcard(), r.getPcard(), r.getBdetail(), r.getAcctype(), r.getAdetail() });
		
	}
	
	public int validate(Login obj){ 
		int status=-1;
		String name=obj.getUname();
	    String sql="select * from group2_registration where uname=?";  
	    Login resultobj= jdbctemplate.queryForObject(sql, new Object[]{name},new BeanPropertyRowMapper<Login>(Login.class));
	    if(resultobj.getPass().equals(obj.getPass()))
	    {
	    	 status=1;
	    	 
	    }
	     
	    else
	    	status=-1;
	    return status;
	    
	}
	/*
	public Registration getCustomerbyUname(String uname)
	{
		String sql = "select * from group2_registration where id=?";
		Registration r = (Registration) jdbctemplate.queryForObject(sql, new Object[] { uname }, new RowMapper()
				{
			
			public Registration mapRow(ResultSet rs, int rowNum) throws SQLException
            {
				
                Registration r = new Registration();
                r.setId(rs.getInt(1));
                r.setAge(rs.getInt(2));
                r.setDept(rs.getString(3));
                r.setName(rs.getString(4));
                return r;
            }
			
			
			
			
				}
						
				);
	}
	*/
	
	/*
	public Registration getEmployeeByUname(String uname)
    {
        String sql = "select * from Employee where id=?";
        Registration employee = (Registration) jdbctemplate.queryForList(sql, new Object[]
        {uname}, new RowMapper()
        {
            @Override
            public Registration mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                Registration r = new Registration();
                r.setName(rs.getString(1));
                r.setAge(rs.getString(2));
                r.setPass(rs.getString(3));
                r.setAcard(rs.getString(4));
                r.setPcard(rs.getString(5));
                r.setBdetail(rs.getString(6));
                r.setAcctype(rs.getString(7));
                r.setAdetail(rs.getString(8));
                return r;
            }
        });
        return employee;
    }
*/
    // Getting all the Employees
    public List<Registration> getAllEmployees()
    {
        String sql = "select * from Employee";

        List<Registration> employeeList = jdbctemplate.query(sql, new ResultSetExtractor<List<Registration>>()
        {
            public List<Registration> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<Registration> list = new LinkedList<Registration>();
                while (rs.next())
                {
                    Registration r = new Registration();
                    r.setName(rs.getString(1));
                    r.setAge(rs.getString(2));
                    r.setUname(rs.getString(3));
                    r.setPass(rs.getString(4));
                    r.setAcard(rs.getString(5));
                    r.setPcard(rs.getString(6));
                    r.setBdetail(rs.getString(7));
                    r.setAcctype(rs.getString(8));
                    r.setAdetail(rs.getString(9));
                    list.add(r);
                }
                return list;
            }

        });
        return employeeList;
    }
/*
    // Updating a particular Employee
    public void updateEmployee(Registration r)
    {
        String sql = "update group2_registration set age =?, dept=?,name=? where id=?";
        jdbctemplate.update(sql, new Object[]
        { employee.getAge(), employee.getDept(), employee.getName(), employee.getId() });
    }

    // Deletion of a particular Employee
    public void deleteEmployee(int id)
    {
        String sql = "delete employee where id=?";
        jdbcTemplate.update(sql, new Object[]
        { id });
    }
	*/
	

}

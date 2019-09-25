package com.capsule.taskmanager.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capsule.taskmanager.model.Users;
import com.capsule.taskmanager.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository<Users> repo;
	
	EntityManager em;
	
	@Transactional
	public Users addUsers(Users user)
	{
		return repo.save(user);
		
	}

	@Transactional
	public List<Users> getallUsers() {
		return (List<Users>) repo.findAll();
	}
	@Transactional
	public Users updateUsers(Users user) {
		Users existingUser = repo.findByemployeeid(user.getEmployeeid());
		
		
		//Query query = em.createNativeQuery("Select * from Users where employeeId = ?", Users.class);
		//query.setParameter(1, user.getEmployeeid());
		//Users existingUser = (Users) query.getSingleResult();
		existingUser.setEmployeeid(user.getEmployeeid());
		existingUser.setFirstname(user.getFirstname());
		existingUser.setLastname(user.getLastname());
		
		Users updatedUser = repo.save(existingUser);
		return updatedUser;
	}
	@Transactional
	public boolean deleteUser(int employee_id) {
		int rowcount = repo.deleteByemployeeid(employee_id);
		if(rowcount > 0)
		{
			return true;
		}
			
		else
		{
			return false;
		}
			
		 
	}
	
	@Transactional 
	public int getTaskCount(int projectId)
	{
		return repo.findtaskCount(projectId);
	}

	@Transactional
	public void updateTaskId(int i, String user) {
		repo.updateTaskid(i, user);
		
	}
	
	@Transactional
	public void updateProjectId(int i, String user)
	{
		repo.updateProjectid(i,user);
	}

	public Users getuserbyname(String user) {
		return repo.findByfirstname(user);
	}

	

}

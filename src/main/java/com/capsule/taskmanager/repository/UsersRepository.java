package com.capsule.taskmanager.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capsule.taskmanager.model.Users;



@Repository
public interface UsersRepository<T> extends CrudRepository<Users, Long>  {

	

	Users findByemployeeid(int employeeid);

	int deleteByemployeeid(int employee_id);
	
	@Query("select count(*) from Task where projectId = ?1")
	int findtaskCount(int projectId);

	@Modifying
	@Query("Update Users set taskid= ?1 where firstname= ?2")
	void updateTaskid(int i, String user);

	@Modifying
	@Query("Update Users set projectid=?1 where firstname=?2")
	void updateProjectid(int i, String user);
	
	
	Users findByfirstname(String user);

	

}

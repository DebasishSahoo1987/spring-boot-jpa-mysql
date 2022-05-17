package com.sbjpa.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sbjpa.example.model.User;
import com.sbjpa.example.model.UserInfo;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<List<User>> findByuserName(String name);
	
	@Query("SELECT u FROM User u WHERE u.salary > 1000")
	Optional<List<User>> findAllTopPaidUsers();
	
	@Query("select new com.sbjpa.example.model.UserInfo(u.userName, u.salary) from User u where u.userName = ?1")
	Optional<List<UserInfo>> findSelectedFieldsForUser(String name);
	
	@Query("select u.userName, u.salary from User u where u.userName = ?1")
	Optional<List<Object[]>> findSelectedFieldsForUser1(String name);
	
//	@Query("SELECT u FROM User u WHERE u.status = ?1")
//	User findUserByStatus(Integer status);
//
//	@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
//	User findUserByStatusAndName(Integer status, String name);

	
	//#####################################
	
// selected fields from a table
	
	/*
	 * You can use projections from Spring Data JPA (doc). In your case, create
	 * interface:
	 * 
	 * interface ProjectIdAndName
	 * { String getId(); 
	 * 	 String getName(); 
	 * } and add
	 * following method to your repository
	 * 
	 * List<ProjectIdAndName> findAll()
	 */
	
	//####################################
	
	/*
	 * @Query("select new com.foo.bar.entity.Document(d.docId, d.filename) from Document d where d.filterCol = ?1"
	 * ) List<Document> findDocumentsForListing(String filterValue);
	 */
	
	//#################
	
	/*
	 * public static final String FIND_PROJECTS =
	 * "SELECT projectId, projectName FROM projects";
	 * 
	 * @Query(value = FIND_PROJECTS, nativeQuery = true) public List<Object[]>
	 * findProjects();
	 */
}



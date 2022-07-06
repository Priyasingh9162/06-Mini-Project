package priya.in.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import priya.in.entity.User;

public interface Repo extends JpaRepository<User, Integer> {
	
@Query(value="select * from user_details where user_id=:caseNo", nativeQuery=true)
	User getuser(int caseNo);

}

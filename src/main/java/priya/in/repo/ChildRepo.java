package priya.in.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import priya.in.entity.DcChild;
import priya.in.entity.DcPlan;

public interface ChildRepo extends JpaRepository<DcChild,Integer> {

	@Query(value="select * from dc_child where case_no=:caseNo", nativeQuery=true)
	public List<DcChild> getplan(int caseNo);

}

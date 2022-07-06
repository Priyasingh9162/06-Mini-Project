package priya.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import priya.in.entity.DcPlan;

public interface PlanRepo extends JpaRepository<DcPlan, Integer> {
	
	@Query(value="select * from dc_plan where case_no=:caseNo", nativeQuery=true)
	public DcPlan getplan(int caseNo);

}

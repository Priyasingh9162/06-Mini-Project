package priya.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import priya.in.entity.DcIncome;
import priya.in.entity.DcPlan;

public interface IncomeRepo extends JpaRepository<DcIncome,Integer> {

	@Query(value="select * from dc_income where case_no=:caseNo", nativeQuery=true)
	public DcIncome getplan(int caseNo);

}

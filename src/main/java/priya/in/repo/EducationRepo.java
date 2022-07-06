package priya.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import priya.in.entity.DcEducation;
import priya.in.entity.DcPlan;

public interface EducationRepo extends JpaRepository<DcEducation,Integer>{

	@Query(value="select * from dc_education where case_no=:caseNo", nativeQuery=true)
	public DcEducation getplan(int caseNo);

}

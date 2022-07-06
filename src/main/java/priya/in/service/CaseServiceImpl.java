package priya.in.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priya.in.entity.CaseDetail;
import priya.in.entity.CaseTriger;
import priya.in.entity.DcChild;
import priya.in.entity.DcEducation;
import priya.in.entity.DcIncome;
import priya.in.entity.DcPlan;
import priya.in.entity.User;
import priya.in.repo.CaseRepo;
import priya.in.repo.ChildRepo;
import priya.in.repo.CtRepo;
import priya.in.repo.EducationRepo;
import priya.in.repo.IncomeRepo;
import priya.in.repo.PlanRepo;
import priya.in.repo.Repo;

@Service
public class CaseServiceImpl implements CaseService {
	@Autowired
	private PlanRepo pr;
	@Autowired
	private EducationRepo er;
	@Autowired
	private IncomeRepo ir;
	@Autowired
	private ChildRepo cr;
	@Autowired
	private Repo repo;
	@Autowired
	private CaseRepo caser;
	@Autowired
	private CtRepo caset;

	@Override
	public CaseDetail checkApproval(Integer caseNo) {
		CaseDetail detail = caser.getDetail(caseNo);
		LocalDate lt = LocalDate.now();
		LocalDate newmonth = lt.plusMonths(3);
		DcPlan plan = pr.getplan(caseNo);
		DcIncome income = ir.getplan(caseNo);
		DcEducation education = er.getplan(caseNo);
		List<DcChild> child = cr.getplan(caseNo);
		User user = repo.getuser(caseNo);
		CaseDetail ct = new CaseDetail();
		CaseDetail dt = caser.getDetail(caseNo);
		if (dt != null)
			ct.setId(dt.getId());
		else
			ct.setId(null);
		ct.setCaseNo(caseNo);
		CaseTriger t = new CaseTriger(null, caseNo, null, "pending");
		long total = (long) (income.getSalary() + income.getProperty() + income.getRent());
		int age = user.getDob().getDayOfYear();
		int now = LocalDate.now().getDayOfYear();
		int currentAge = now - age;

		if (plan.getPlanName().equals("SNAP")) {

			if (total > 5000) {

				ct.setHolderName(user.getFirstName());
				ct.setBenifitAmt((long) 5000);
				ct.setDenaiedReason("your income is more than 5000");
				ct.setHolderSSN("67897");
				ct.setPlanName(plan.getPlanName());
				ct.setPlanStatus("Denaied");
				ct.setStartDate(lt);
				ct.setEndDate(newmonth);

			} else {

				ct.setHolderName(user.getFirstName());
				ct.setBenifitAmt((long) 5000);
				ct.setDenaiedReason("null");
				ct.setHolderSSN("67897");
				ct.setPlanName(plan.getPlanName());
				ct.setPlanStatus("Approve");
				ct.setStartDate(lt);
				ct.setEndDate(newmonth);
			}

		}

		else if (plan.getPlanName().equals("CCAP")) {
			boolean flag = true;
			for (DcChild c : child) {
				if (c.getChildAge() > 16)
					flag = false;
			}
			if (total < 5000 && flag == true && !child.isEmpty()) {
				ct.setHolderName(user.getFirstName());
				ct.setBenifitAmt((long) 5000);
				ct.setDenaiedReason("null");
				ct.setHolderSSN("67897");
				ct.setPlanName(plan.getPlanName());
				ct.setPlanStatus("Approve");
				ct.setStartDate(lt);
				ct.setEndDate(newmonth);
			} else {
				ct.setHolderName(user.getFirstName());
				ct.setBenifitAmt((long) 5000);
				if (total > 5000)
					ct.setDenaiedReason("your income is more than 5000");
				if (flag == false)
					ct.setDenaiedReason("child age is grater than 16");
				if (child.isEmpty())
					ct.setDenaiedReason("you do not have any child");
				ct.setHolderSSN("67897");
				ct.setPlanName(plan.getPlanName());
				ct.setPlanStatus("Denaied");
				ct.setStartDate(lt);
				ct.setEndDate(newmonth);
			}

		} else if (plan.getPlanName().equals("MEDICAID")) {
			if (total < 5000 && income.getProperty() == 0) {
				ct.setHolderName(user.getFirstName());
				ct.setBenifitAmt((long) 5000);
				ct.setDenaiedReason("null");
				ct.setHolderSSN("67897");
				ct.setPlanName(plan.getPlanName());
				ct.setPlanStatus("Approve");
				ct.setStartDate(lt);
				ct.setEndDate(newmonth);

			} else {
				ct.setHolderName(user.getFirstName());
				ct.setBenifitAmt((long) 5000);
				if (total > 5000)
					ct.setDenaiedReason("your income is grater than 5000");
				if (income.getProperty() > 0)
					ct.setDenaiedReason("your have some property");
				ct.setHolderSSN("67897");
				ct.setPlanName(plan.getPlanName());
				ct.setPlanStatus("Denaied");
				ct.setStartDate(lt);
				ct.setEndDate(newmonth);
			}
		} else if (plan.getPlanName().equals("MEDICARE")) {
			if (currentAge >= 65) {
				ct.setHolderName(user.getFirstName());
				ct.setBenifitAmt((long) 5000);
				ct.setDenaiedReason("null");
				ct.setHolderSSN("67897");
				ct.setPlanName(plan.getPlanName());
				ct.setPlanStatus("Approve");
				ct.setStartDate(lt);
				ct.setEndDate(newmonth);
			} else {
				ct.setHolderName(user.getFirstName());
				ct.setBenifitAmt((long) 5000);
				ct.setDenaiedReason("your age is less than 65");
				ct.setHolderSSN("67897");
				ct.setPlanName(plan.getPlanName());
				ct.setPlanStatus("Denaied");
				ct.setStartDate(lt);
				ct.setEndDate(newmonth);
			}
		} else if (plan.getPlanName().equals("NJW")) {
			if (total == 0 && education.getGratuationStatus()) {
				ct.setHolderName(user.getFirstName());
				ct.setBenifitAmt((long) 5000);
				ct.setDenaiedReason("null");
				ct.setHolderSSN("67897");
				ct.setPlanName(plan.getPlanName());
				ct.setPlanStatus("Approve");
				ct.setStartDate(lt);
				ct.setEndDate(newmonth);
			} else {
				ct.setHolderName(user.getFirstName());
				ct.setBenifitAmt((long) 5000);
				if (total > 0)
					ct.setDenaiedReason("you are not unemployed");
				if (!education.getGratuationStatus())
					ct.setDenaiedReason("you are not gratuate");
				ct.setHolderSSN("67897");
				ct.setPlanName(plan.getPlanName());
				ct.setPlanStatus("Denied");
				ct.setStartDate(lt);
				ct.setEndDate(newmonth);
			}
		}

		CaseDetail save = caser.save(ct);
		this.saveCO(t);
		return save;

	}

	@Override
	public Boolean saveCO(CaseTriger ct) {
		CaseTriger triger = caset.getTriger(ct.getCaseNo());
		if (triger != null)
			ct.setId(triger.getId());
		CaseTriger save = caset.save(ct);
		if (save != null)
			return true;
		return false;
	}

}

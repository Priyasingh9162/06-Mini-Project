package priya.in.service;

import priya.in.entity.CaseDetail;
import priya.in.entity.CaseTriger;

public interface CaseService {

	CaseDetail checkApproval(Integer caseNo);
	Boolean saveCO(CaseTriger ct);
}

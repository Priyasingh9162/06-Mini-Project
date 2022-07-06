package priya.in.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import priya.in.entity.CaseDetail;
import priya.in.service.CaseServiceImpl;

@RestController
public class Rest {

	@Autowired
	private CaseServiceImpl service;
	
	@GetMapping("/check/approval/{caseNo}")
	public CaseDetail checkApproval(@PathVariable int caseNo) {
		return service.checkApproval(caseNo);
		
	}
	
}

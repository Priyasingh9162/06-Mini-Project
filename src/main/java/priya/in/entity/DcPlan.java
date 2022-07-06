package priya.in.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name="DC_Plan")
public class DcPlan {
	@Id
	@Column(name="Id")
	private Integer id;
	@Column(name="Case_No")
	private Integer caseNo;
	@Column(name="Plan_Name")
	private String planName;
	
	public DcPlan() {
		
	}
	
}

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
@Table(name="DC_Child")
public class DcChild {


	@Id
	@Column(name="Id")
	private Integer id;
	@Column(name="Case_No")
	private Integer caseNo;
	@Column(name="Child_Name")
	private String childName;
	@Column(name="Child_Age")
	private Integer childAge;
	@Column(name="Child_SSN")
	private String ssn;
	
	public DcChild() {
		
	}
	
}

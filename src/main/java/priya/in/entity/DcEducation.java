package priya.in.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name="DC_Education")
public class DcEducation {

	@Id
	@Column(name="Id")
	private Integer id;
	@Column(name="Case_No")
	private Integer caseNo;
	@Column(name="Gratuation_Status")
	private Boolean gratuationStatus;
	@Column(name="Gratuation_Year")
	private LocalDate gratuationYear;
	@Column(name="University")
	private String university;
	@Column(name="Highest_Degree")
	private String highestDegree;
	
	public DcEducation() {
		
	}
	
}

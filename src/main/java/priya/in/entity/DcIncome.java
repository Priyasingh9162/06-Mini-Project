package priya.in.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="DC_Income")
public class DcIncome {

	@Id
	@Column(name="Id")
	private Integer id;
	@Column(name="Case_No")
	private Integer caseNo;
	@Column(name="Salary_Income")
	private Double salary;
	@Column(name="Property_Income")
	private Double property;
	@Column(name="Rent_Income")
	private Double rent;
	
}

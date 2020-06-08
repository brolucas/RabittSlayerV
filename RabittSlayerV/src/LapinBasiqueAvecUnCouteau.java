import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
@Entity
public class LapinBasiqueAvecUnCouteau extends PNJ implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id;
	private int ind;
	public LapinBasiqueAvecUnCouteau() {
		this.setnom("LapinUnPeuMechantMaisPasTrop");
		this.setSymb("L");
		this.setatt(5);
		this.setdef(5);
		this.setdeg(5);
		this.setesq(5);
		this.setini(5);
	}
	public int getInd() {
		return ind;
	}
	public void setInd(int ind) {
		this.ind = ind;
	}
}

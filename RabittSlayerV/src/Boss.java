import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Boss extends PNJ implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id;
	private int ind;
	public Boss() {
		this.setnom("LapinUnPeuTropMechant");
		this.setSymb("B");
		this.setatt(15);
		this.setdef(15);
		this.setdeg(15);
		this.setesq(5);
		this.setini(5);
	}

}

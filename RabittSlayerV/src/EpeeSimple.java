import java.io.Serializable;

import javax.persistence.*;
@Entity
public class EpeeSimple extends Equipement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id ;

	public EpeeSimple() {
		this.setType("Epée simple");
		this.setImpact(7);
		this.setManiabilité(7);
	}
}

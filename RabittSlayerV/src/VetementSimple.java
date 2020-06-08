import java.io.Serializable;


import javax.persistence.*;
@Entity
public class VetementSimple extends Equipement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id;

	public VetementSimple() {
		this.setType("Vetement Simple");
		this.setEncombrement(3);
		this.setSolidité(5);		
	}

}

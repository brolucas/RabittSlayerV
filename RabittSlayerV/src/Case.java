import java.io.Serializable;

import javax.persistence.*;
@Entity
public class Case implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id;
	Equipement e ;
	PNJ pnj;
	Joueur j;
	String Symb;
	int etat=0;
	int i;
	int y;
	boolean havepnj;
	int equip = 0;
	
	public boolean haveequi() {
		if (this.equip == 1) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public Case(String t, int i, int y) {
		this.Symb= t;
		this.i = i;
		this.y = y;
		this.etat = 1;
		
	}
	public Case(int i, int y) {
		this.Symb = " ";
		this.i = i;
		this.y = y;
		
	}
	public Case(Joueur j, int i, int y) {
		this.Symb = j.getSymb();
		this.i = i;
		this.i = y;
		this.etat=1;
	
	}
	public Case(Equipement  e, int i, int y) {
		this.Symb = e.getSymb();
		this.i = i;
		this.i = y;
		this.etat=0;
		this.e = e;
		this.equip =1;
	
	}
	public Case(PNJ pnj, int i, int y) {
		this.Symb = pnj.getSymb();
		this.i = i;
		this.y = y;
		this.etat=1;
		this.havepnj =true;
	}
	public void setpnj(PNJ t) {
		this.pnj = t;
		this.Symb = t.getSymb();
		t.setPosition(this.i, this.y);
		this.etat=1;
		this.havepnj=true;
	}
	public void setJoueur(Joueur t) {
		this.j = t;
		this.Symb = t.getSymb();
		t.setPosition(this.i, this.y);
		this.etat=1;
		if (this.equip== 1) {
			t.sac.add(this.e);
			System.out.println("Equipement rammasser");
			this.equip =0;
		}
		
	}
	public PNJ getpnj(){
		return this.pnj;
		
	}
	public void seti(int val) {
		this.i = val;
	}
	public void sety(int val) {
		this.y = val;
	}
	public int geti() {
		return this.i;
	}
	public int gety() {
		return this.y;
	}
	public void setetat(int e) {
		this.etat=e;
		
	}
	public int getetat() {
		return this.etat;
	}
	public void delJ() {
		this.j = null;
	}
	public void maj() {
		if (this.j != null) {
			this.setSymbJ(this.j);
			this.etat= 1;
		}
		if (this.pnj != null) {
			this.setSymb(this.pnj);
			this.etat=1;
		}
		else {
			this.etat = 0;
		}
		
	}
	public void setSymbJ(Joueur j) {
		this.Symb = j.getSymb();
	}
	public void setSymb(PNJ p) {
		this.Symb = p.getSymb();
	}
	public void del() {
		this.etat =0;
		this.j= null;
		this.pnj = null;
		this.Symb =" "; 
	}
	public void setetat() {
		this.etat=0;
	}
	
	public Equipement getequip() {
		Equipement et = this.e;
		this.e = null;
		return et;
	}
	public void setequip(Equipement eq) {
		this.e = eq;
		this.equip=1;
	}
	
	
}


public abstract class Equipement {
	String Type;
	int Maniabilité;
	int Impact;
	int Encombrement;
	int Solidité;
	
	public String getType() { return this.Type; }
	protected void setType(String type) {this.Type = type;}
	public int getManiabilité() {return this.Maniabilité;}
	protected void setManiabilité(int t) {this.Maniabilité = t;}
	public int getImpact() {return this.Impact;}
	protected void setImpact(int t) {this.Impact = t;}
	public int getEncombrement() {return this.Encombrement;}
	protected void setEncombrement(int t) {this.Encombrement = t;}
	public int getSolidité() {return this.Solidité;}
	protected void setSolidité(int t) {this.Solidité = t;}
}

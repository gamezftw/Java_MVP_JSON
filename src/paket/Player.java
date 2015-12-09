package paket;

import java.util.ArrayList;

public class Player {
	
	private String id;
	private String firstname;
	private String lastname;
	private String team;
	private int gp;
	private int min;
	private int pts;
	private int oreb;
	private int dreb;
	private int asts;
	private int stl;
	private int blk;
	private int to;
	private int pf;
	private int fga;
	private int fgm;
	private int fta;
	private int ftm;
	private int tpa;
	private int tpm;
	private ArrayList<String> pos = new ArrayList<>();
	private int result;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getGp() {
		return gp;
	}
	public void setGp(int gp) {
		this.gp = gp;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getPts() {
		return pts;
	}
	public void setPts(int pts) {
		this.pts = pts;
	}
	public int getOreb() {
		return oreb;
	}
	public void setOreb(int oreb) {
		this.oreb = oreb;
	}
	public int getDreb() {
		return dreb;
	}
	public void setDreb(int dreb) {
		this.dreb = dreb;
	}
	public int getAsts() {
		return asts;
	}
	public void setAsts(int asts) {
		this.asts = asts;
	}
	public int getStl() {
		return stl;
	}
	public void setStl(int stl) {
		this.stl = stl;
	}
	public int getBlk() {
		return blk;
	}
	public void setBlk(int blk) {
		this.blk = blk;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public int getPf() {
		return pf;
	}
	public void setPf(int pf) {
		this.pf = pf;
	}
	public int getFga() {
		return fga;
	}
	public void setFga(int fga) {
		this.fga = fga;
	}
	public int getFgm() {
		return fgm;
	}
	public void setFgm(int fgm) {
		this.fgm = fgm;
	}
	public int getFta() {
		return fta;
	}
	public void setFta(int fta) {
		this.fta = fta;
	}
	public int getFtm() {
		return ftm;
	}
	public void setFtm(int ftm) {
		this.ftm = ftm;
	}
	public int getTpa() {
		return tpa;
	}
	public void setTpa(int tpa) {
		this.tpa = tpa;
	}
	public int getTpm() {
		return tpm;
	}
	public void setTpm(int tpm) {
		this.tpm = tpm;
	}
	public ArrayList<String> getPos() {
		return pos;
	}
	public void setPos(ArrayList<String> pos) {
		this.pos = pos;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
}

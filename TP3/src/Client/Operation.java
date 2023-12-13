package Client;

import java.io.Serializable;

public class Operation implements Serializable {
	String op1,op2,op;
	int res;
	public Operation(String op1,String op2,String op) {
		this.op1=op1;
		this.op2=op2;
		this.op=op;
	}
	public String getop1() {
		return op1;
	}
	public String getop2() {
		return op2;
	}
	public String getop() {
		return op;
	}
	public void setRes(int res) {
		this.res=res;
	}
	public int getRes() {
		return res;
	}
}

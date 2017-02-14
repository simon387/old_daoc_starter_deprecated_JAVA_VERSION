package com.logic;
/**
 * MADE IN ITALY
 * @author Simone
 */
public class Client {
	
	public int PID = 0;
	public String nomeAccount = null;
	public String nomeToon = null;
	
	public Client(int PID, String nomeAccount, String nomeToon) {
		this.PID = PID;
		this.nomeAccount = nomeAccount;
		this.nomeToon = nomeToon;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Client) {
			Client client = (Client)object;
			if (client.PID == this.PID) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.PID;
	}
	
	@Override
	public String toString() {
		return this.PID + ":" + this.nomeAccount + "_" + this.nomeToon;
	}
}

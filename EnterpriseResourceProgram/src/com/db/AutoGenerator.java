
package com.db;

import java.util.ArrayList;


public class AutoGenerator {
	public AutoGenerator(){
	}
	public String autoIncreaseAccountList(ArrayList<AccountListDTO> list){
		int n=1;
		for(AccountListDTO dto : list){
			if(dto.getID() == n) {
				n++;
			}
		}
		return String.valueOf(n);
	}
	public String autoIncreaseEmployee(ArrayList<EmployeeDTO> list){
		int n=1;
		for(EmployeeDTO dto : list){
			if(dto.getID() == n) {
				n++;
			}
		}
		return String.valueOf(n);
	}
	
	
}
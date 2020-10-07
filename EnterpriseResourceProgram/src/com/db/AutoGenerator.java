package com.db;

import java.util.ArrayList;
import java.util.Random;

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
	public String autoIncreaseMaterials(ArrayList<MaterialsDTO> list){
		int n=1;
		for(MaterialsDTO dto : list){
			if(dto.getID() == n) {
				n++;
			}
		}
		return String.valueOf(n);
	}
	public String autoIncreaseProduct(ArrayList<ProductDTO> list){
		int n=1;
		for(ProductDTO dto : list){
			if(dto.getID() == n) {
				n++;
			}
		}
		return String.valueOf(n);
	}
	public String autoIncreaseProductionList(ArrayList<ProductionListDTO> list){
		int n=1;
		for(ProductionListDTO dto : list){
			if(dto.getID() == n) {
				n++;
			}
		}
		return String.valueOf(n);
	}
	public String autoIncreaseProductionListNo(ArrayList<ProductionListDTO> list){
		int n=0;
		for(ProductionListDTO dto : list){
			if(dto.getID() == n) {
				n++;
			}
		}
		return String.valueOf(n);
	}
	public String autoIncreaseProductionManagementNo(ArrayList<ProductionManagementDTO> list, String product){
		int n=0;
		for(ProductionManagementDTO dto : list){
			if(dto.getID().equals(product + Integer.toString(n))) {
				n++;
			}
		}
		return product + Integer.toString(n);
	}
	public String autoIncreasePurchase(ArrayList<PurchaseDTO> list){
		int n=1;
		for(PurchaseDTO dto : list){
			if(dto.getID() == n) {
				n++;
			}
		}
		return String.valueOf(n);
	}
	
	public String autoIncreaseSale(ArrayList<SaleDTO> list){
		int n=1;
		for(SaleDTO dto : list){
			if(dto.getID() == n) {
				n++;
			}
		}
		return String.valueOf(n);
	}
	
	public String autoPassword() {
		String s=null;
		char[] c= new char[36];
		for(int i=0; i<26 ;i++) {
			c[i]= (char)('a' + i);
		}
		for(int i=0;i<10;i++) {
			c[i+26]=(char)('0' + i);
		}
		long seed = System.currentTimeMillis();
		Random r=new Random(seed);
		char[] ch = new char[7];
		
		for(int i=0;i<7;i++) {
			ch[i]=c[r.nextInt(36)];
		}
		s=String.valueOf(ch);
		System.out.println(s);
			
		return s;
	}
}

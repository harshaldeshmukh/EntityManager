package com.example.spring.entitymanager;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="msphc_master")
public class CompletedProjectList {
	
	@Id
	private Long ID;
	private String  project_name;
	private String  project_management_consultant;
	private String  contractor;
	private String  project_status;
	private String lat;
	private String lng;
	private String PID;
	
	private String  scope_of_work;
	private String architecht;
	private String district;
	private String unit_commandar;
	
	private String  address;
	private String built_up_area;
	private String actual_expenditure;
	
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_management_consultant() {
		return project_management_consultant;
	}
	public void setProject_management_consultant(String project_management_consultant) {
		this.project_management_consultant = project_management_consultant;
	}
	public String getContractor() {
		return contractor;
	}
	public void setContractor(String contractor) {
		this.contractor = contractor;
	}
	public String getProject_status() {
		return project_status;
	}
	public void setProject_status(String project_status) {
		this.project_status = project_status;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getPID() {
		return PID;
	}
	public void setPID(String pID) {
		PID = pID;
	}
	
	
	public String getScope_of_work() {
		return scope_of_work;
	}
	public void setScope_of_work(String scope_of_work) {
		this.scope_of_work = scope_of_work;
	}
	public String getArchitecht() {
		return architecht;
	}
	public void setArchitecht(String architecht) {
		this.architecht = architecht;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getUnit_commandar() {
		return unit_commandar;
	}
	public void setUnit_commandar(String unit_commandar) {
		this.unit_commandar = unit_commandar;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBuilt_up_area() {
		return built_up_area;
	}
	public void setBuilt_up_area(String built_up_area) {
		this.built_up_area = built_up_area;
	}
	public String getActual_expenditure() {
		return actual_expenditure;
	}
	public void setActual_expenditure(String actual_expenditure) {
		this.actual_expenditure = actual_expenditure;
	}
	@Override
	public String toString() {
		return "CompletedProjectList [ID=" + ID + ", project_name=" + project_name + ", project_management_consultant="
				+ project_management_consultant + ", contractor=" + contractor + ", project_status=" + project_status
				+ ", lat=" + lat + ", lng=" + lng + ", PID=" + PID + "]";
	}
	
	
	

}

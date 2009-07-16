package de.t5book.entities;

import org.apache.tapestry5.ioc.annotations.Inject;

public class ReportParameter<T> {
	private String name;
	private T value;
	
	@Inject
	public ReportParameter() {
		super();
	}
	public ReportParameter(String name) {
		super();
		this.name = name;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ReportParameter)){
			return false;
		}
		ReportParameter other = (ReportParameter)obj;
		if(!getName().equals(other.getName())){
			return false;
		}
		return true;
	}
}

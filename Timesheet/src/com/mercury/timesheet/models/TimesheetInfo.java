package com.mercury.timesheet.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TimesheetInfo {
	private List<RecordInfo> records;
	
	public TimesheetInfo() {
		records = new ArrayList<RecordInfo>();
	}

	public List<RecordInfo> getRecords() {
		return records;
	}
	@XmlElement(name="record")
	public void setRecords(List<RecordInfo> records) {
		this.records = records;
	}
	
	public void addRecord(RecordInfo recordInfo) {
		records.add(recordInfo);
	}
	
	public void removeRecord(RecordInfo recordInfo) {
		records.remove(recordInfo);
	}
}

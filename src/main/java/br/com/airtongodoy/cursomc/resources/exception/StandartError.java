package br.com.airtongodoy.cursomc.resources.exception;

import java.io.Serializable;

public class StandartError implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer errorStatus;
	private String errorMessage;
	private Long errorTimeStamp;
	
	
	public StandartError(Integer errorStatus, String errorMessage, Long errorTimeStamp) {
		super();
		this.errorStatus = errorStatus;
		this.errorMessage = errorMessage;
		this.errorTimeStamp = errorTimeStamp;
	}
	
	public Integer getErrorStatus() {
		return errorStatus;
	}
	public void setErrorStatus(Integer errorStatus) {
		this.errorStatus = errorStatus;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public Long getErrorTimeStamp() {
		return errorTimeStamp;
	}
	public void setErrorTimeStamp(Long errorTimeStamp) {
		this.errorTimeStamp = errorTimeStamp;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errorMessage == null) ? 0 : errorMessage.hashCode());
		result = prime * result + ((errorStatus == null) ? 0 : errorStatus.hashCode());
		result = prime * result + ((errorTimeStamp == null) ? 0 : errorTimeStamp.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StandartError other = (StandartError) obj;
		if (errorMessage == null) {
			if (other.errorMessage != null)
				return false;
		} else if (!errorMessage.equals(other.errorMessage))
			return false;
		if (errorStatus == null) {
			if (other.errorStatus != null)
				return false;
		} else if (!errorStatus.equals(other.errorStatus))
			return false;
		if (errorTimeStamp == null) {
			if (other.errorTimeStamp != null)
				return false;
		} else if (!errorTimeStamp.equals(other.errorTimeStamp))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StandartError [errorStatus=" + errorStatus + ", errorMessage=" + errorMessage + ", errorTimeStamp="
				+ errorTimeStamp + "]";
	}
	
	
}

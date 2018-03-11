package struts.request.mapping;

import java.util.List;

public class ResultEntity {
	private ResultType resultType;
	private List<MapPair> params;

	public ResultEntity(ResultType resultType, List<MapPair> params) {
		this.resultType = resultType;
		this.params = params;
	}

	public ResultType getResultType() {
		return resultType;
	}

	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}

	public List<MapPair> getParams() {
		return params;
	}

	public void setParams(List<MapPair> params) {
		this.params = params;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += resultType + " - {";
		for(MapPair param : params) {
			str += param + ",";
		}
		str += "}";
		return str;
	}

}

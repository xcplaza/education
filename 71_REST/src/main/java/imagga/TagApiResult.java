package imagga;

import java.util.Map;

public class TagApiResult {
	public Result result;
	public Status status;
}

class Result {
	public Tag[] tags;
}

class Tag {
	public double confidence;
	public Map<String, String> tag;
}

class Status {
	public String text;
	public String type;
}
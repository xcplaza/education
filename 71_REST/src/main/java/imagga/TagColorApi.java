package imagga;

import java.util.Map;

public class TagColorApi {
	public Result_color result_color;
	public Status status;
}

class Result_color {
	public Colors colors;
}

class Colors {
	public Background_colors[] background_colors;
	public double color_percent_threshold;
	public int color_variance;
	public Foreground_colors[] foreground_colors;
	public Image_colors[] image_colors;
	public double object_percentage;
}

class Background_colors {
	public Map<String, String> bColor;
}

class Foreground_colors {
	public Map<String, String> fColor;
}

class Image_colors{
	public Map<String, String> iColor;
}

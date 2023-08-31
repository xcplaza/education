package color;
public class ColorsApiResult 
{
	public ColorsResult result;
	public Status status;
}
class Color 
{
	public String closest_palette_color;
	public String closest_palette_color_parent;
	public double percent;
}
class Colors 
{
	public Color[] background_colors;
	public Color[] foreground_colors;
	public Color[] image_colors;
}
class ColorsResult 
{
	public Colors colors;
}
class Status 
{
	public String text;
	public String type;
}



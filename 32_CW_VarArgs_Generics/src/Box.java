
public class Box<T> { // типизируем по типу который в дальнейшем захотим использовать
	/*
	 * E - Element 
	 * K - Key 
	 * V - Value 
	 * N - Number 
	 * T - Type 
	 * <> обозначаем типизацию
	 */
	private T value;

	public Box(T value) {
		setValue(value);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	

}

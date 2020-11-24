package test.mypac;

public class FruitBox<T> {	// genetic class (=포괄 클래스)
	public T item;	//field type = 'T'
	
	public void setItem(T item) {
		this.item=item;
	}
	
	public T getItem() {
		return this.item;
	}
	
//	new Fruit(); X

	//변수 a,b,c 에 담는 법
//	FruitBox<Apple> a = new FruitBox<Apple>();
//	FruitBox<Banana> b = new FruitBox<Banana>();
//	FruitBox<Orange> c = new FruitBox<Orange>();
}

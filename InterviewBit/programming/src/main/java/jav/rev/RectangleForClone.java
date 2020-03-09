package jav.rev;

public class RectangleForClone implements Cloneable{
	
	float length;
	float width;
	
	public RectangleForClone(float l,float w){
		this.length = l;
		this.width = w;
	}
	
	public float area(){
		return length*width;
	}
	
	@Override
	public RectangleForClone clone() throws CloneNotSupportedException{
		return (RectangleForClone) super.clone();
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		RectangleForClone orig = new RectangleForClone(2, 5);
		RectangleForClone copy = orig.clone();
		System.out.println(orig.area());
		System.out.println(copy.area());
		System.out.println(orig!=copy);
		System.out.println(orig.getClass()==copy.getClass());
		System.out.println(orig.equals(copy));
		
	}
}

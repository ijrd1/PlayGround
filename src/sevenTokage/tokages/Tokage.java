package sevenTokage.tokages;

import java.util.List;

import sevenTokage.attributes.Color;
import sevenTokage.attributes.Element;

/*
 * トカゲというモノがあるらしいよ・・・(ざわざわ)
 * よくわかんないけどね。
 */
public abstract class Tokage  {

	String name ;
	Color color;
	Element element;
	List<Color> colorList = Color.colorList();

	Tokage(){
		System.out.println(" /|_/|");
		System.out.println("(・・ )");
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	public void setColor(Color color){
		this.color = color;
	}
	public Color getColor(){
		return color;
	}

	public void setElement(Element element){
		this.element = element;
	}
	public Element getElement(){
		return element;
	}




}

import java.io.*;
import java.util.*;

public class ej1{
	public static class Bag implements Serializable{
		private String color;
		private int count;

		public Bag(String color, int count){
			this.color = color;
			this.count = count;
		}

		public String getColor(){
			return this.color;
		}

		public int getCount(){
			return this.count;
		}

		@Override
		public boolean equals(Object bag2){
			if(bag2 != null && bag2 instanceof Bag){
				if(((Bag) bag2).getColor() != null && ((Bag) bag2).getColor().equals(this.getColor())){
					return true;
				}
			}
			return false;
		}

		@Override
		public int hashCode(){
			return 31 * getColor().hashCode();
		}

		public String toString(){
			return count + " " + color;
		}
	}

	public static Map<Bag, List<Bag>> bags = new HashMap<>();

	public static void main(String[] args) {
		String noBags = "no other bags";
		String join = " contain ";

		try{
			BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
			String linea;
			String[] splitContain;
			String main = "", sub = "";
			Bag mainBag, tempBag;
			List<Bag> subs = new LinkedList<>();

			while((linea = br.readLine()) != null){
				subs = new LinkedList<>();

				splitContain = linea.split(join);
				mainBag = new Bag(splitContain[0].trim(), 1);
				sub = splitContain[1].trim();

				if(sub.indexOf(noBags) == -1){
					splitContain = sub.split(", ");
					for(int i = 0; i < splitContain.length; i++){
						String ammount = "", color = "";
						int j = 0;
						char c;

						while((c = splitContain[i].charAt(j)) != ' '){
							ammount += c;
							j++;
						}

						ammount = splitContain[i].substring(0, j);
						color = splitContain[i].substring(j+1, splitContain[i].length()).replace(".", "").replace("bag", "bags").replace("bagss", "bags");

						Bag bag = new Bag(color, Integer.parseInt(ammount));
						subs.add(bag);
					}
				}

				if(!bags.containsKey(mainBag)){
					bags.put(mainBag, subs);
				}
			}

			int count = 0;

			for(Map.Entry<Bag, List<Bag>> entry : bags.entrySet()) {
				Bag key = entry.getKey();
				List<Bag> value = entry.getValue();
				
				if(hasShinyBag(key, value)){
					count++;
				}
			}
			System.out.println("Colores: " + (count - 1)); //Se cuenta la shiny gold de más
		}catch(Exception e){
			System.out.println("Oh no: " + e.toString());
		}
	}

	public static boolean hasShinyBag(Bag bag, List<Bag> list){ //Se puede mejorar guardando un array de colores que contienen shiny bags
		if(bag.getColor().indexOf("shiny gold") != -1){
			return true;
		}else{
			for(int i = 0; i < list.size(); i++){
				Bag bag2 = new Bag(list.get(i).getColor(), 1);
				if(hasShinyBag(list.get(i), bags.get(bag2))){
					return true;
				}
			}
		}
		return false;
	}
}
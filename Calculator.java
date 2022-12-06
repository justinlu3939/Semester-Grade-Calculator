import java.util.*;
import java.util.ArrayList;

class category
{
	Scanner in = new Scanner(System.in);
	
	String name = "";
	double weight;
	ArrayList<Double> grades = new ArrayList<Double>();
	double averageGrade;
	
	category(String name, double weight)
	{
		this.name = name;
		this.weight = weight/100;
	}
	public void enterGrades()
	{
		double grade;
		while(true)
		{
			System.out.print("Enter a grade for \"" + name + "\": (Enter -1 to stop) ");
			grade = in.nextDouble();
			if(grade == -1)
			{
				break;
			}
			grades.add(grade);
		}
	}
	public void calculateAVG() {
		int total = 0;
		for(int i = 0; i < grades.size(); i++)
		{
			total += grades.get(i);
		}
		averageGrade = (double)(total/grades.size());
	}
	public double returnWeightedAVG()
	{
		calculateAVG();
		return (averageGrade * weight);
	}
	public void print()
	{
		calculateAVG();
		System.out.println("__" + name + "___");
		System.out.println("Average Grade: " + averageGrade);
		System.out.println("Weighted Average Grade: " + returnWeightedAVG() + "\n");
	}
}
public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		ArrayList<category> categories = new ArrayList<category>();
		String name = "";
		double weight = 0;
		double totalWeight = 0;
		double remainingPercent = 100;
		int finalGrade = 0;
		
		
		while(true)
		{
			System.out.print("Enter the name of the category (type stop to stop): ");
			name = in.next();
			if(name.equals("stop"))
			{
				break;
			}
			System.out.println("Remaining weighted needed: " + remainingPercent + "%");
			System.out.print("Enter the weight of this category: ");
			weight = in.nextDouble();
			totalWeight += weight;
			remainingPercent -= weight;
			category newCat = new category(name, weight);
			newCat.enterGrades();
			categories.add(newCat);
		}
		
		for(int i = 0; i < categories.size(); i++)
		{
			categories.get(i).print();
		}
		
		if(totalWeight != (double)100)
		{
			System.out.println("The weight percentage is not 100%");
		}
		else
		{
			for(int i = 0; i < categories.size(); i++)
			{
				finalGrade += categories.get(i).returnWeightedAVG();
			}
			System.out.println("\nFinal course grade: " + finalGrade);
		}
	}

}

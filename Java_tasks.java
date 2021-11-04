import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

class FirstTask
{
    public void getIntegersFromList(List<Object> list) 
    {
        List<Integer> array = new ArrayList<Integer>();
        for (Integer i = 0; i < list.size(); i++) 
        {
            if (list.get(i) instanceof Integer)
            {
                array.add((Integer) list.get(i));
            }
        }
        System.out.println("Given by examples: "+ list +" Answer: "+ array);
    }
}

class SecondTask
{
    static final int NO_OF_CHARS = 256;
    static char count[] = new char[NO_OF_CHARS];
    
    static void getCharCountArray(String word)
    {
        for (int i = 0; i < word.length(); i++)
        {
            count[word.charAt(i)]++;
        }
    }
    
    public int first_non_repeating_letter(String word)
    {
        getCharCountArray(word);
        int index = -1;
        for (int i = 0; i < word.length(); i++) 
        {
            if (count[word.charAt(i)] == 1) 
            {
                index = i;
                break;
            }
        }
        return index;
    }

    public void print_first_non_repeating_letter(String word)
    {
        int index = first_non_repeating_letter(word);
        System.out.println(index == -1? "Either all characters are repeating or string in word ("+ word +") is empty": "First non-repeating character in word ("+ word +") is "+ word.charAt(index));
    }
} 

class ThirdTask
{
    public int getDigitalRoot(int n)
    {
        System.out.printf("getDigtal root(%d) => ", n);
        int root = 0;
        while(n > 0 || root > 9)
        {
            if (n == 0)
            {
               n = root;
               root = 0;
            }
            
            root += n % 10;
            n /= 10;
        }
        return root;
    }
}

class FourthTask
{
    public void getPairsCount1(int[] array1, int target1)
    {
        int count1 = 0;
        for(int i = 0; i < array1.length; i++)
        {
            for(int j = i + 1; j < array1.length; j++)
            {
                if(array1[i] + array1[j] == target1)
                {
                   count1++; 
                }
            }
        }
        System.out.printf("Number of pairs in the array, the sum of which will give target(through for): %d\n", count1);
    }
    
    public static int getPairsCount2(List<Integer> array2, int target2) 
    {
        int count2 = IntStream.range(0, array2.size())
                .map(i -> (int) IntStream.range(0, array2.size())
                .filter(j -> i != j && array2.get(i) + array2.get(j) == target2).count()).sum();
        return count2 / 2;
    }
}

class FifthTask
{
    public String SelectandSort(String s) 
    {
        List<FirstnameAndLastname> toSort = new ArrayList<>();
        for (String s1 : s.split(";")) {
            String toUpperCase = s1.toUpperCase();
            FirstnameAndLastname firstnameAndlastname = SelectPersonalFirstnameAndLastname(toUpperCase);
            toSort.add(firstnameAndlastname);
        }
        toSort.sort(Comparator.comparing(FirstnameAndLastname::getLastname).thenComparing(FirstnameAndLastname::getFirstname));
        StringBuilder stringbuilder = new StringBuilder();
        for (FirstnameAndLastname firstnameAndLastname : toSort) {
            String format = firstnameAndLastname.format();
            stringbuilder.append(format);
        }
        return stringbuilder.toString();
    }

    private static FirstnameAndLastname SelectPersonalFirstnameAndLastname(String personalname) 
    {
        var split = personalname.split(":");
        var firstname = split[0];
        var lastname = split[1];
        return new FirstnameAndLastname(firstname, lastname);
    }

    private static class FirstnameAndLastname 
    {
        private final String firstname;
        private final String lastname;

        public FirstnameAndLastname(String firstname, String lastname) 
        {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public String getFirstname() 
        {
            return firstname;
        }

        public String getLastname() 
        {
            return lastname;
        }

        public String format() 
        {
            return String.format("(%s, %s)", this.lastname, this.firstname);
        }
    }
}

public class Java_tasks
{    public static void main(String[] args) 
	{
	    FirstTask first = new FirstTask();
	    System.out.println("First Task:");
        System.out.println("Examples: getIntegersFromList(Arrays.asList(1,2,'a','b')=>{1,2}");
        System.out.println("getIntegersFromList(Arrays.asList(1,2,'a','b',0,15)=>{1,2,0,15}");
        System.out.println("getIntegersFromList(Arrays.asList(1,2,'a','b','aasf','1','123',231))=>{1,2,231}");
        System.out.println("Answer:");
	    first.getIntegersFromList(Arrays.asList(1,2,"a","b"));
	    first.getIntegersFromList(Arrays.asList(1,2,"a","b",0,15));
	    first.getIntegersFromList(Arrays.asList(1,2,"a","b","aasf","1","123", 231));
	    
	    SecondTask second = new SecondTask();
	    System.out.println("Second task:");
        System.out.println("Examples: a => a; stress => t; sTreSS => T; papa => empty");
	    String word = "a";
	    String word1 = "stress";
	    String word2 = "sTreSS";
	    String word3 = "papa";
        System.out.println("Answer:");
        second.print_first_non_repeating_letter(word);
        second.print_first_non_repeating_letter(word1);
        second.print_first_non_repeating_letter(word2);
        second.print_first_non_repeating_letter(word3);
	    
	    ThirdTask third = new ThirdTask();
	    System.out.println("Third task:");
        System.out.println("Examples: digital_root(16) => 1 + 6 => 7");
        System.out.println("digital_root(942) => 9 + 4 + 2 => 15 => 1 + 5=> 6");
        System.out.println("digital_root(132189) => 1 + 3 + 2 + 1 + 8 + 9 => 24 => 2 + 4 => 6");
        System.out.println("digital_root(493193) => 4 + 9 + 3 + 1 + 9 + 3 => 29 => 2 + 9 => 11 => 1 + 1 => 2");
        System.out.println("Answer:");
	    System.out.printf("%d\n", third.getDigitalRoot(16));
	    System.out.printf("%d\n", third.getDigitalRoot(942));
	    System.out.printf("%d\n", third.getDigitalRoot(132189));
	    System.out.printf("%d\n", third.getDigitalRoot(493193));
	    
	    FourthTask four = new FourthTask();
	    int[] array = {1, 3, 6, 2, 2, 0, 4, 5};
	    int target = 5;
	    System.out.println("Four task:");
        System.out.println("Examles: There is an array of numbers - arr [1, 3, 6, 2, 2, 0, 4, 5], there is a number target = 5.");
        System.out.println("[1,4],[3,2],[3,2],[0,5] => 4");
        System.out.println("Answer:");
	    four.getPairsCount1(array,target);
        System.out.printf("Number of pairs in the array, the sum of which will give target(through stream): %d\n", four.getPairsCount2(Arrays.asList(1, 3, 6, 2, 2, 0, 4, 5), target));
	    
	    FifthTask five = new FifthTask();
	    System.out.println("Fifth Task:");
        System.out.println("Examples:(Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill) => (CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)");
        System.out.println("Answer:");
	    System.out.println(five.SelectandSort("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill"));
	}
	
}
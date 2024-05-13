package streams;

import java.util.Random;

public class SportLoto {
	
	record sportlotoPar(int minVal,int maxVal, int amount)
	{
	
	};

	public static void main(String[] args)
	{
		//printing out sportloto random numbers
		//application with command line mandatory arguments
		//first argument minimal inclusive value
		//second argument maximal inclusive value
		//third argument amount of the random numbers
		//Example: java -jar sportLoto 1 49 7
		// 3, 10, 49, 1, 40, 6, 7
		try 
		{
			sportlotoPar slPar = getsportlotoPar(args);
			printSportlotoPar(slPar);
			printPrizeNumbers(slPar);
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	private static void printSportlotoPar(sportlotoPar slPar)
	{
		System.out.printf("Sportloto [%d] from [%d]. From [%d] to [%d] .\nPrize numbers: ",slPar.amount, slPar.maxVal-slPar.minVal+1, slPar.minVal, slPar.maxVal);
		
	}

	private static void printPrizeNumbers(sportlotoPar slPar)
	{
		new Random().ints(slPar.minVal, slPar.maxVal+1).distinct().limit(slPar.amount).forEach(n->System.out.printf("%d ",n));		
	}

	private static sportlotoPar getsportlotoPar(String[] args) throws Exception
	{
		String forAllExc=String.format("SportLoto <MinValue> <MaxValue> <AmountPrizeNumber>\n");
		if(args.length!=3)
		{
			String exc=String.format(forAllExc+"Number of paramers not equals 3");
			throw new Exception(exc);
		}
		int minVal=Integer.parseInt(args[0]);
		if(minVal<0)
		{
			String exc=String.format(forAllExc+"Input error: <MinValue> = [%d] less than 0", minVal);
			throw new Exception(exc);	
		}
		int maxVal=Integer.parseInt(args[1]);
		if(maxVal<=minVal)
		{
			String exc=String.format(forAllExc+"Input error: <MaxValue> = [%d] less or equals than <MinValue>",maxVal);
			throw new Exception(exc);	
		}
		int amount=Integer.parseInt(args[2]);
		if(amount<1)
		{
			String exc=String.format(forAllExc+"Input error: <AmountPrizeNumber>  = [%d] less than 1",amount);
			throw new Exception(exc);		
		}
		if(amount>maxVal-minVal+1)
		{
			String exc=String.format(forAllExc+"Input error: <AmountPrizeNumber>  = [%d] more than total number of possible numbers  = [%d]", amount, maxVal-minVal+1);
			throw new Exception(exc);		
		}
		return new sportlotoPar(minVal, maxVal,amount);
	}

}
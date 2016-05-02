public class Sum {

    public static int sumNumbers(int[] nums) throws Magic47Exception{
        int i = 0;
        int sum = 0;
        while(i < nums.length){
            sum += nums[i];
            i++;
        }
        if (sum == 47){
            throw new Magic47Exception();
        }
        return sum;
    }

    public static void main(String[] args){
        int[] newArgs = new int[args.length];
        int i = 0;
        int sum = 0;
        while (i < args.length){
            newArgs[i] = Integer.parseInt(args[i]);
	    i++;
	}
        try{
           sum =  sumNumbers(newArgs);
		System.out.println(sum);
        }
        catch (Magic47Exception me){
            System.out.println("You got 47!!");
        }
    }
}

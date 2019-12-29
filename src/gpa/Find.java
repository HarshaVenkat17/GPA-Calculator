package gpa;
class Find 
{
    int MAX=15;
    int sum=0,count=0;
    double[] rgpa=new double[MAX];
    int[] s1g,s2g,s3g,s4g,s5g,s6g,s7g,s8g;
    double gpa,SD1,SD2,SD3,SD4,SD5,SD6,SD7,SD8,M1,M2,M3,M4,M5,M6,M7,M8;
    public double[] calculate(int[] s1,int[] s2,int[] s3,int[] s4,int[] s5,int[] s6,int[] s7,int[] s8,int[] c)
    {
       for(count=0;count< s1.length;count++)
        {
            if(s1[count]==0)
                break;
        }
       SD1=calculateSD(count,s1);SD2=calculateSD(count,s2);SD3=calculateSD(count,s3);SD4=calculateSD(count,s4);
       SD5=calculateSD(count,s5);SD6=calculateSD(count,s6);SD7=calculateSD(count,s7);SD8=calculateSD(count,s8);
       M1=calculateM(count,s1);M2=calculateM(count,s2);M3=calculateM(count,s3);M4=calculateM(count,s4);
       M5=calculateM(count,s5);M6=calculateM(count,s6);M7=calculateM(count,s7);M8=calculateM(count,s8);
        
       s1g=FindG(count,s1,M1,SD1);s2g=FindG(count,s2,M2,SD2);s3g=FindG(count,s3,M3,SD3);s4g=FindG(count,s4,M4,SD4);
       s5g=FindG(count,s5,M5,SD6);s6g=FindG(count,s6,M6,SD6);s7g=FindG(count,s7,M7,SD7);s8g=FindG(count,s8,M8,SD8);
    
        for(int i=0;i<count;i++)
        {
            rgpa[i]=calculateG(i,c,s1g,s2g,s3g,s4g,s5g,s6g,s7g,s8g);
        }
        return rgpa;
    }
    public static double calculateG(int k,int[] c,int[] r1,int[] r2,int[] r3,int[] r4,int[] r5,int[] r6,int[] r7,int[] r8)
    {
      double sum;
      sum=c[0]*r1[k]+c[1]*r2[k]+c[2]*r3[k]+c[3]*r4[k]+c[4]*r5[k]+c[5]*r6[k]+c[6]*r7[k]+c[7]*r8[k];
      return (sum/(c[0]+c[1]+c[2]+c[3]+c[4]+c[5]+c[6]+c[7]));
    }
    public static int[] FindG(int count,int[] sub,double m,double sd)
    {
      int[] s=new int[count];
      for(int i=0;i<count;i++)
        {
            if(sub[i]>m+1.5*sd){s[i]=10;}
            else if(sub[i]>m+sd){s[i]=9;}
            else if(sub[i]>m+0.5*sd){s[i]=8;}
            else if(sub[i]>m){s[i]=7;}
            else if(sub[i]>m-0.5*sd){s[i]=6;}
            else if(sub[i]>m-sd){s[i]=5;}
            else {s[i]=4;}
        }   
      return s;
      
    }
    public static double calculateM(int count,int numArray[])
    {
        double sum = 0.0;
        for(double num : numArray) {
            sum += num;
        }
        return (sum/count);
    }

    public static double calculateSD(int count,int numArray[])
    {
        double sum = 0.0, standardDeviation = 0.0;
        int i;
        for (i=0;i<count;i++)
        {
            sum=sum+numArray[i];
        }
        double mean = sum/count;
        for(i=0;i<count;i++)
        {
            standardDeviation+=Math.pow(numArray[i]-mean,2);
        }
        
        double send=Math.sqrt(standardDeviation/(count));
        return send;
    }
}
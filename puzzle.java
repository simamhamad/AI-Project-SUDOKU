
package sudokugame;

public class puzzle {
    int size;
  Check check=new Check();
 
    public int[][] createPuzzle(int choose){
      if(choose==1){size=28;}
      if(choose==2){size=24;}
      if(choose==3){size=20;}
      int [][]puzzle={{0,0,0,0,0,0,0,0,0},                        //r1
                   {0,0,0,0,0,0,0,0,0},                        //r2
                   {0,0,0,0,0,0,0,0,0},                        //r3
                   {0,0,0,0,0,0,0,0,0},                        //r4
                   {0,0,0,0,0,0,0,0,0},                        //r5
                   {0,0,0,0,0,0,0,0,0},                        //r6
                   {0,0,0,0,0,0,0,0,0},                        //r7
                   {0,0,0,0,0,0,0,0,0},                        //r8
                   {0,0,0,0,0,0,0,0,0}      };
        int []indexi=new int [size];
           int []indexj=new int [size];
       for(int ii=0;ii<indexi.length;ii++){
        
          for(;;){
               int number=(int)((Math.random()*9)+1);
           int r=(int)(Math.random()*9);
            int c=(int)(Math.random()*9);
                if(check.checkrc(r, c, indexj,indexi)){
                  indexi[ii]=r;indexj[ii]=c;
                 if(check.RowColumnCheck(number, r, c, puzzle)){
             if(check.SquireCheck(number, r, c, puzzle)){
                 puzzle[r][c]=number;
                 break;
         
             }}}}}
           return puzzle;   
    }
}

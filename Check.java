
package sudokugame;

public class Check {
    boolean e;
    int [][]square=new int[3][3];
public boolean RowColumnCheck(int numinput,int i,int j,int p[][]){
    int count=0;
    for(int k=0;k<9;k++){
    if(numinput!=p[i][(j+k)%9]){
        if(numinput!=p[(i+k)%9][j]){
            count++;      }
       }
     }
  if(count==9){ return true;}
        return false;
    }
public boolean SquireCheck (int numinput,int i,int j,int p[][]){
       
   if(i%3==0){                             //row 1 
     if(j%3==0){                            //column 1
      if(numinput!=p[i][j+1] && numinput!=p[i][j+2]){
      if(numinput!=p[i+1][j] && numinput!=p[i+1][j+1] && numinput!=p[i+1][j+2]){
      if(numinput!=p[i+2][j]&& numinput!=p[i+2][j+1] && numinput!=p[i+2][j+2]){
                                  return true;   }  }   }   }
                        
     if(j%3==1){                           //column 2
      if(numinput!=p[i][j+1] && numinput!=p[i][j-1]){
      if(numinput!=p[i+1][j] && numinput!=p[i+1][j+1] && numinput!=p[i+1][j-1]){
      if(numinput!=p[i+2][j]&& numinput!=p[i+2][j+1] && numinput!=p[i+2][j-1]){
                                  return true;    }   }   }  }
                       
     if(j%3==2){                            //column 3
      if(numinput!=p[i][j-1] && numinput!=p[i][j-2]){
      if(numinput!=p[i+1][j] && numinput!=p[i+1][j-1] && numinput!=p[i+1][j-2]){
      if(numinput!=p[i+2][j]&& numinput!=p[i+2][j-1] && numinput!=p[i+2][j-2]){
                     return true;      }   }  }  }  }
                   
    if(i%3==1){                          //row 2
     
     if(j%3==0){                            //column 1
       if(numinput!=p[i][j+1] && numinput!=p[i][j+2]){
       if(numinput!=p[i+1][j]&& numinput!=p[i+1][j+1]&& numinput!=p[i+1][j+2]){
       if(numinput!=p[i-1][j]&& numinput!=p[i-1][j+1]&& numinput!=p[i-1][j+2]){
                                   return true;    }  }  }   }
                      
     if(j%3==1){                           //column 2
      if(numinput!=p[i][j+1] && numinput!=p[i][j-1]){
      if(numinput!=p[i+1][j] && numinput!=p[i+1][j+1]&& numinput!=p[i+1][j-1]){
      if(numinput!=p[i-1][j]&& numinput!=p[i-1][j+1] && numinput!=p[i-1][j-1]){
                                   return true;     }  } } }
                       
     if(j%3==2){                          //column 3
      if(numinput!=p[i][j-1] && numinput!=p[i][j-2]){
      if(numinput!=p[i+1][j] && numinput!=p[i+1][j-1]&& numinput!=p[i+1][j-2]){
      if(numinput!=p[i-1][j]&& numinput!=p[i-1][j-1] && numinput!=p[i-1][j-2]){
                              return true;    }    }  }  }  }
                     
    if(i%3==2){                         //row 3 
      
     if(j%3==0){                           //column 1
      if(numinput!=p[i][j+1] && numinput!=p[i][j+2]){
      if(numinput!=p[i-1][j] && numinput!=p[i-1][j+1]&& numinput!=p[i-1][j+2]){
      if(numinput!=p[i-2][j]&& numinput!=p[i-2][j+1] && numinput!=p[i-2][j+2]){
                                   return true;    }   }  }  }
                        
     if(j%3==1){           //column 2
      if(numinput!=p[i][j+1] && numinput!=p[i][j-1]){
      if(numinput!=p[i-1][j] && numinput!=p[i-1][j+1]&& numinput!=p[i-1][j-1]){
      if(numinput!=p[i-2][j]&& numinput!=p[i-2][j+1] && numinput!=p[i-2][j-1]){
                                  return true;        }    }  }   }
                   
     if(j%3==2){            //column 3
      if(numinput!=p[i][j-1] && numinput!=p[i][j-2]){
      if(numinput!=p[i-1][j] && numinput!=p[i-1][j-1]&& numinput!=p[i-1][j-2]){
      if(numinput!=p[i-2][j]&& numinput!=p[i-2][j-1] && numinput!=p[i-2][j-2]){
                                  return true;       }    }    }  }  }
                   
            return false;   } 
    public boolean checkrc(int r,int c,int[]ii,int[]jj){
        for(int i=0;i<ii.length;i++){
                if(ii[i]!=(i+1)%(ii.length) && ii[i]!=(i+2)%(ii.length)){
                    if(jj[i]!=(i+1)%(ii.length) && jj[i]!=(i+2)%(ii.length)){
            return true;
        }
    }}
        return false;
}    }
    
    

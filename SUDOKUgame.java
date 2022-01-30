
package sudokugame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;


public class SUDOKUgame extends JFrame implements ActionListener {
    
     JPanel p1;         //panel 
     JLabel l1;           //label 1 for head
    JLabel l2;           //label 2 for warning
    //  button to all number
     JButton b1;
     JButton b2;
     JButton b3;
     JButton b4;
     JButton b5;
     JButton b6;
     JButton b7;
     JButton b8;
     JButton b9;
     // button to other action
     JButton bhelp;
     JButton breplay;
     JButton bclean;
     // all for imageicon
     ImageIcon icon1;
       ImageIcon icon2;
      Graphics g;
     
     JTable table ;     //table for puzzle
              //object for class that I created
       puzzle puz;
        Check check;
        int puzzle[][];
        int matrix[][];
    public SUDOKUgame(){
        
        super("SUDOKU");
        l1=new JLabel("SUDOKU");
        l1.setBounds(250, 15, 300, 50);
        l1.setFont(new java.awt.Font("Segoe UI", 1, 48));
        
        l2=new JLabel();
        l2.setBounds(250, 90, 300,20);
        l2.setFont(new java.awt.Font("Calibri", 1, 14));
        
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(95, 202, 227));
        
        table= new JTable(9,9);
        table.setBounds(170, 120, 400, 400);
        table.setRowHeight(45);
       table.setFont(new Font("Arial", Font.ITALIC, 24));
      table.setCellSelectionEnabled(true);
      //button numbers
        b1=new JButton("1");
        b1.setBounds(50,  550, 60, 40);
        b1.addActionListener(this);
       
        b2=new JButton("2");
        b2.setBounds(120, 550, 60, 40);
        b2.addActionListener(this);
        
        b3=new JButton("3");
        b3.setBounds(190, 550, 60, 40);
        b3.addActionListener(this);
   
        b4=new JButton("4");
        b4.setBounds(260, 550, 60, 40);
        b4.addActionListener(this);
     
        b5=new JButton("5");
        b5.setBounds(330, 550, 60, 40);
        b5.addActionListener(this);
     
        b6=new JButton("6");
        b6.setBounds(400, 550, 60, 40);
        b6.addActionListener(this);
     
        b7=new JButton("7");
        b7.setBounds(470, 550, 60, 40);
        b7.addActionListener(this);
     
        b8=new JButton("8");
        b8.setBounds(540,  550, 60, 40);
        b8.addActionListener(this);
     
        b9=new JButton("9");
        b9.setBounds(610, 550, 60, 40);
        b9.addActionListener(this);
          
      icon1 = new ImageIcon("C:\\imageIIcon.jpg");
      Image img = icon1.getImage() ;  
      Image newimg=img.getScaledInstance(70,70, java.awt.Image.SCALE_SMOOTH );  
      icon1 = new ImageIcon( newimg );
        
      icon2 = new ImageIcon("C:\\RefreshIcon.jpg");
      Image img1 = icon2.getImage() ;  
      Image newimg1=img1.getScaledInstance(70,70,java.awt.Image.SCALE_SMOOTH );  
      icon2 = new ImageIcon( newimg1 );
          
        bhelp=new JButton( icon1);
        bhelp.setBackground(new Color(95, 202, 227));
        bhelp.setBounds(600, 100,70, 70);
        bhelp.addActionListener(this);
        bhelp.setForeground(new Color(95, 202, 227));
        bhelp.setBorderPainted(false);
          
        breplay=new JButton(icon2);
        breplay.setBackground(new Color(95, 202, 227));
        breplay.setBounds(600, 200,70, 70);
        breplay.addActionListener(this);
        breplay.setForeground(new Color(95, 202, 227));
        breplay.setBorderPainted(false);
         
        bclean=new JButton("clean");
        bclean.setBounds(600, 300,70, 30);
        bclean.addActionListener(this);
         
        check=new Check();
        puz=new puzzle();
        puzzle=new int[9][9];
       
        add(p1);
        p1.add(table);
        
        p1.add(l1);
        p1.add(l2);
        
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        p1.add(b7);
        p1.add(b8);
        p1.add(b9);
           
        p1.add(bhelp);
        p1.add(breplay);
        p1.add(bclean);
           setSize(800,800);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setVisible(true);                                  }
         
    public void puzzle(int choose){
    puzzle=puz.createPuzzle(choose);
     
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
            if(puzzle[i][j]!=0){
              table.setValueAt("  "+puzzle[i][j], i, j);
               }
                   
                }    }   }
     
       
    
    public static void main(String[] args) {
     String choose=JOptionPane.showInputDialog("1.Easy, 2.Normal ,3.Hard");
    SUDOKUgame sudoku= new SUDOKUgame();
        sudoku.puzzle(Integer.parseInt(choose));
    
        }
    
    @Override

    public void actionPerformed(ActionEvent e) {
        l2.setText("  ");
      if(e.getSource()==bhelp){
        for(;;){
          int number=(int)((Math.random()*9)+1);
          int r=(int)(Math.random()*9);
          int c=(int)(Math.random()*9);
          if(puzzle[r][c]==0){ 
           if(check.RowColumnCheck(number, r, c, puzzle)){
          if(check.SquireCheck(number, r, c, puzzle)){
          table.setValueAt(number,r, c);
                puzzle[r][c]=number;  break; }  }  } } }
        
      else if(e.getSource()==breplay){                                 
        Thread thread;
          thread = new Thread(){
            public void run(){
         String choose=JOptionPane.showInputDialog("1.Easy, 2.Normal ,3.Hard");
            SUDOKUgame sudoku1= new SUDOKUgame();
            sudoku1.puzzle(Integer.parseInt(choose));
                }
            };
            thread.start();
        }        
        
      
        
    
   if (e.getSource()==b1){
       if( table.getSelectedRow()==-1){l2.setText("You must select one cell ,that is null"); } 
       else{
           if(check.RowColumnCheck(1,table.getSelectedRow(),table.getSelectedColumn(),puzzle)){
        if(check.SquireCheck(1,table.getSelectedRow(),table.getSelectedColumn(),puzzle)){
           table.setValueAt("  1", table.getSelectedRow(), table.getSelectedColumn());
                 puzzle[table.getSelectedRow()][table.getSelectedColumn()]=1; }    }  
    else{   l2.setText("The number replay in row,column or squire triangle");    }  } }
        
   if(e.getSource()==b2){       //button number 2              
     if( table.getSelectedRow()==-1){l2.setText("You must select one cell ,that is null"); } 
     else{
         if(check.RowColumnCheck(2, table.getSelectedRow(), table.getSelectedColumn(), puzzle)){
        if(check.SquireCheck(2, table.getSelectedRow(), table.getSelectedColumn(), puzzle)){
           table.setValueAt("  2", table.getSelectedRow(), table.getSelectedColumn());
                     puzzle[table.getSelectedRow()][table.getSelectedColumn()]=2; }        }
    else{    l2.setText("The number replay in row,column or squire triangle");   } } }
       
    if(e.getSource()==b3){                          //button number 3     
           if( table.getSelectedRow()==-1){l2.setText("You must select one cell ,that is null"); } 
           else{
               if(check.RowColumnCheck(3, table.getSelectedRow(), table.getSelectedColumn(), puzzle)){
             if(check.SquireCheck(3, table.getSelectedRow(), table.getSelectedColumn(), puzzle)){
          table.setValueAt("  3", table.getSelectedRow(), table.getSelectedColumn());
                   puzzle[table.getSelectedRow()][table.getSelectedColumn()]=3; }     }
   else{ l2.setText("The number replay in row,column or squire triangle");     } }  }
       
    if(e.getSource()==b4){          //button number 4          
       if( table.getSelectedRow()==-1){l2.setText("You must select one cell ,that is null"); } 
       else{ 
           if(check.RowColumnCheck(4, table.getSelectedRow(), table.getSelectedColumn(), puzzle)){
           if(check.SquireCheck(4, table.getSelectedRow(), table.getSelectedColumn(), puzzle)){
          table.setValueAt(" 4", table.getSelectedRow(), table.getSelectedColumn());
              puzzle[table.getSelectedRow()][table.getSelectedColumn()]=4;  }     }
       else{ l2.setText("The number replay in row,column or squire ");   } }  }
      
      
    if(e.getSource()==b5){       //button number 5        
      if( table.getSelectedRow()==-1){l2.setText("You must select one cell ,that is null"); } 
      else{  
          if(check.RowColumnCheck(5, table.getSelectedRow(), table.getSelectedColumn(), puzzle)){
          if(check.SquireCheck(5, table.getSelectedRow(), table.getSelectedColumn(), puzzle)){
          table.setValueAt("  5", table.getSelectedRow(), table.getSelectedColumn());
                 puzzle[table.getSelectedRow()][table.getSelectedColumn()]=5;  }  }
    else{ l2.setText("The number replay in row,column or squire triangle");  } }  }
        
    
    if(e.getSource()==b6){    //button number 6           
      if( table.getSelectedRow()==-1){l2.setText("You must select one cell ,that is null"); } 
      else{
          if(check.RowColumnCheck(6, table.getSelectedRow(), table.getSelectedColumn(), puzzle)){
          if(check.SquireCheck(6, table.getSelectedRow(), table.getSelectedColumn(), puzzle)){
          table.setValueAt("  6", table.getSelectedRow(), table.getSelectedColumn());
             puzzle[table.getSelectedRow()][table.getSelectedColumn()]=6;  }   }
       else{ l2.setText("The number replay in row,column or squire triangle");  } }  }
       
    if(e.getSource()==b7){     //button number 7
       if( table.getSelectedRow()==-1){l2.setText("You must select one cell ,that is null"); } 
       else{
           if(check.RowColumnCheck(7, table.getSelectedRow(), table.getSelectedColumn(), puzzle)){
           if(check.SquireCheck(7, table.getSelectedRow(), table.getSelectedColumn(), puzzle)){
            table.setValueAt("  7", table.getSelectedRow(), table.getSelectedColumn());
              puzzle[table.getSelectedRow()][table.getSelectedColumn()]=7;  }   }
      else{ l2.setText("The number replay in row,column or squire triangle"); }  }  }
    
    if(e.getSource()==b8){    //button number 8
      if( table.getSelectedRow()==-1){l2.setText("You must select one cell ,that is null"); } 
      else{
          if(check.RowColumnCheck(8, table.getSelectedRow(), table.getSelectedColumn(), puzzle)){
          if(check.SquireCheck(8, table.getSelectedRow(), table.getSelectedColumn(), puzzle)){
          table.setValueAt("  8", table.getSelectedRow(), table.getSelectedColumn());
             puzzle[table.getSelectedRow()][table.getSelectedColumn()]=8;  }   }
      else{ l2.setText("The number replay in row,column or squire triangle");   }}  }
    
    if(e.getSource()==b9){                          //button number 9   
       if( table.getSelectedRow()==-1){l2.setText("You must select one cell ,that is null"); } 
       else{
           if(check.RowColumnCheck(9, table.getSelectedRow(), table.getSelectedColumn(), puzzle)){
           if(check.SquireCheck(9, table.getSelectedRow(), table.getSelectedColumn(), puzzle)){
          table.setValueAt("  9", table.getSelectedRow(), table.getSelectedColumn());
             puzzle[table.getSelectedRow()][table.getSelectedColumn()]=9;  }    }
      else{ l2.setText("The number replay in row,column or squire triangle");   } }  }
       
     
    if (e.getSource()==bclean){
      if( table.getSelectedRow()==-1){l2.setText("You must select one cell ,that is null"); } 
        else{ table.setValueAt("  ", table.getSelectedRow(), table.getSelectedColumn());
             puzzle[table.getSelectedRow()][table.getSelectedColumn()]=0;}
         }
    }    
}

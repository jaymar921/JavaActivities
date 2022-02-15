/**
   Student Management System
   By Abejar, Jayharron Mar C
   
   Lastname: TextField
   Firstname: TextField
   Birthdate: TextField
   Course: TextField
   Yearlevel: TextField
   Gender: RadioButton
   
   Buttons
   Add Student: 
      gets data from textfields and radiobutton, create a new instance of student by parsing
      the collected data and adding to the list.
   Remove Student:
      Gets the id number and look for a student instance that has the same id number that is 
      looked for.
   Exit:
      simply exits the program :>
   Load:
      Load the student_data.txt that contains the list of students that was previously added
   Save:
      Saves the students_list into the student_data.txt
      
   Program Dependencies:
      - Birthdate.class
      - Student.class
      - List.cass (interface)
      - StudentList.class
      - student_data.txt (creates new if file not exist)
      
      StudentManagement Class{
         Constructor StudentManagement() - Creates the GUI, initializes attributes
         Listener actionPerformed() - do some program action when buttons are clicked
         void save() - save the list into student_data.txt
         void load() - loads the student_data.txt
      }
**/
import javax.swing.border.LineBorder;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.StringTokenizer;
public class StudentManagement extends JFrame implements ActionListener{

   JTextField TFlastname, TFfirstname, TFbirthdate, TFcourse, TFyearlevel;
   JLabel sms,stl, lblLastname, lblFirstname, lblBirthdate, lblCourse, lblYearlevel, lblGender, lblresult1,lblresult2,lblresult3,lblresult4,lblresult5;
   JButton btnAdd, btnRemove, btnExit, btnLoad, btnSave;
   JRadioButton gender1, gender2;
   ButtonGroup GenderRad;
   int idno = 0;
   int stored_id = 0;
   List student_list = new StudentList();
   
   public StudentManagement(){
      super("Student Management System by Jayharron");
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      JPanel ui = new JPanel(new BorderLayout(1,1));
      JPanel form = new JPanel(new GridLayout(9, 3, 1,1));
      JPanel result = new JPanel(new GridLayout(6,1,10,30));
      JPanel fileButtons = new JPanel(new GridLayout(1,2));
      Font  font1  = new Font(Font.SANS_SERIF, Font.BOLD,  15);
      Font  font2  = new Font(Font.SERIF, Font.BOLD,  20);
      ui.add(form, BorderLayout.CENTER);
      
      //this Class is to get the screen size
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
   
        // Determine the new location of the window
      int w = this.getSize().width;
      int h = this.getSize().height;
      int x = (dim.width-w)/4;  
      int y = (dim.height-h)/4;
   
        // Move the window
      setLocation(x, y); // trying to make it at the center if possible
      
      //setLayout(new GridLayout(9,3));
      setContentPane(ui);
      //initializing the text fields
      TFlastname = new JTextField();
      TFfirstname = new JTextField();
      TFbirthdate = new JTextField();
      TFcourse = new JTextField();
      TFyearlevel = new JTextField();
      
      //labels
      sms = new JLabel("Student Management System");
      sms.setFont(font2);
      stl =new JLabel("STUDENT LIST",SwingConstants.CENTER);
      stl.setFont(font2);
      lblLastname = new JLabel("Lastname:");
      lblFirstname = new JLabel("Firstname:");
      lblBirthdate = new JLabel("Birthdate[DD/MM/YY]:");
      lblCourse = new JLabel("Course:");
      lblYearlevel = new JLabel("Year Level:");
      lblGender = new JLabel("Gender:");
      lblresult1 = new JLabel(" ",SwingConstants.CENTER);
      lblresult1.setFont(font1);
      lblresult2 = new JLabel(" ",SwingConstants.CENTER);
      lblresult2.setFont(font1);
      lblresult3 = new JLabel(" ",SwingConstants.CENTER);
      lblresult3.setFont(font1);
      lblresult4 = new JLabel(" ",SwingConstants.CENTER);
      lblresult4.setFont(font1);
      lblresult5 = new JLabel(" ",SwingConstants.CENTER);
      lblresult5.setFont(font1);
      //buttons
      btnAdd = new JButton("Add Student");
      btnAdd.setMnemonic('d');
      btnRemove = new JButton("Remove Student");
      btnRemove.setMnemonic('o');
      btnExit = new JButton("Exit");
      btnExit.setMnemonic('x');
      gender1 = new JRadioButton("Male");
      gender2 = new JRadioButton("Female");
      btnLoad = new JButton("Load");
      btnSave = new JButton("Save");
      
      form.add(new JLabel(""));
      form.add(sms);
      form.add(new JLabel(""));
      form.add(lblLastname);
      form.add(TFlastname);
      form.add(new JLabel("*"));
      form.add(lblFirstname);
      form.add(TFfirstname);
      form.add(new JLabel("*"));
      form.add(lblBirthdate);
      form.add(TFbirthdate);
      form.add(new JLabel("*"));
      form.add(lblCourse);
      form.add(TFcourse);
      form.add(new JLabel("*"));
      form.add(lblYearlevel);
      form.add(TFyearlevel);
      form.add(new JLabel("*"));
      form.add(lblGender);
      form.add(gender1);
      form.add(gender2);
      form.add(btnAdd);
      form.add(btnRemove);
      form.add(btnExit);
      form.add(new JLabel(""));
      form.add(stl);
      form.add(new JLabel(""));
      
      setSize(500,700);
      GenderRad = new ButtonGroup();
      GenderRad.add(gender1);
      GenderRad.add(gender2);
      btnExit.addActionListener(this);
      btnRemove.addActionListener(this);
      btnAdd.addActionListener(this);
      
      fileButtons.add(btnLoad);
      fileButtons.add(btnSave);
      btnLoad.addActionListener(this);
      btnSave.addActionListener(this);
   
      result.add(lblresult1);
      result.add(lblresult2);
      result.add(lblresult3);
      result.add(lblresult4);
      result.add(lblresult5);
      result.add(fileButtons);
      ui.add(result, BorderLayout.SOUTH);
      pack();
   }
   
   ///action performed
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == btnExit)
         System.exit(0);
      if(e.getSource() == btnAdd){
         if((TFlastname.getText() != "") && (TFfirstname.getText() != "") && (TFbirthdate.getText() != "") && (TFcourse.getText() != "") && (TFyearlevel.getText() != "") && (gender1.isSelected() || gender2.isSelected())){
         
            try{
               String lastname = TFlastname.getText();
               String firstname = TFfirstname.getText();
               String birthdate = TFbirthdate.getText();
               String[] b = birthdate.split("/");
               String course = TFcourse.getText();
               String year = TFyearlevel.getText();
               char gender = '\u0000';
               if(gender1.isSelected())
                  gender = 'M';
               else if(gender2.isSelected())
                  gender = 'F';
               else
                  gender = 'n';
                 
               
               student_list.add(new Student(lastname, firstname, new Birthdate(Integer.parseInt(b[0]), Integer.parseInt(b[1]), Integer.parseInt(b[2])), gender, Integer.parseInt(year), course, ++idno));
               //lblresult1.setText(student_list.toString());
               String contents = student_list.toString();
               String[] list = contents.split("~");
               int size = list.length;
               int traverse = 0;
               for(String a: list){
                  if(size <= 5){
                     if(traverse == 0)
                        lblresult1.setText(list[traverse]);
                     if(traverse == 1)
                        lblresult2.setText(list[traverse]);
                     if(traverse == 2)
                        lblresult3.setText(list[traverse]);
                     if(traverse == 3)
                        lblresult4.setText(list[traverse]);
                     if(traverse == 4)
                        lblresult5.setText(list[traverse]);
                     traverse++;
                  }else{
                     lblresult1.setText(list[size-5]);
                     lblresult2.setText(list[size-4]);
                     lblresult3.setText(list[size-3]);
                     lblresult4.setText(list[size-2]);
                     lblresult5.setText(list[size-1]);
                  }
               }
               
            }catch(Exception error){
               JOptionPane.showMessageDialog(null, "An error has occured\nMake sure all fields are filled correctly");
            }finally{
               TFlastname.setText("");
               TFfirstname.setText("");
               TFbirthdate.setText("");
               TFcourse.setText("");
               TFyearlevel.setText("");
               GenderRad.clearSelection();
            }
         }
      }
      if(e.getSource() == btnRemove){
         String id_string = JOptionPane.showInputDialog(null,"Enter ID number: ");
         try{
            int id_number = Integer.parseInt(id_string);
            boolean ok = student_list.isFound(id_number);
            if(ok){
               JOptionPane.showMessageDialog(null, "ID: "+id_string+"\nis found and removed");
               student_list.remove(id_number);
            }else{
               JOptionPane.showMessageDialog(null, "ID: "+id_string+"\nwas not found!");
            }
         }catch(Exception er){
            JOptionPane.showMessageDialog(null, "Invalid input :/");
         }finally{
            lblresult1.setText(" ");
            lblresult2.setText(" ");
            lblresult3.setText(" ");
            lblresult4.setText(" ");
            lblresult5.setText(" ");
         }
         String contents = student_list.toString();
         String[] list = contents.split("~");
         int size = list.length;
         int traverse = 0;
         for(String a: list){
            if(size <= 5){
               if(traverse == 0)
                  lblresult1.setText(list[traverse]);
               if(traverse == 1)
                  lblresult2.setText(list[traverse]);
               if(traverse == 2)
                  lblresult3.setText(list[traverse]);
               if(traverse == 3)
                  lblresult4.setText(list[traverse]);
               if(traverse == 4)
                  lblresult5.setText(list[traverse]);
               traverse++;
            }else{
               lblresult1.setText(list[size-5]);
               lblresult2.setText(list[size-4]);
               lblresult3.setText(list[size-3]);
               lblresult4.setText(list[size-2]);
               lblresult5.setText(list[size-1]);
            }
         }
      }
      if(e.getSource() == btnSave){
         
         int input = JOptionPane.showConfirmDialog(null, "would you like to save the data?");
         if(input == 0)
            save();
      }
      if(e.getSource() == btnLoad){
         int input = JOptionPane.showConfirmDialog(null, "would you like to load the data?");
         if(input == 0)
            load();
      }
   }
   //save the student_list to student_data.txt
   public void save(){
      String fileContent = "";
      CryptoCode _crypt = new  CryptoCode(2);//
      try { 
         StringTokenizer st = new StringTokenizer(student_list.toString(),":,|-~");
            
         while(st.hasMoreTokens()){
            String sn = st.nextToken();
            String ln = st.nextToken();
            String fn = st.nextToken();
            String idno_s = st.nextToken();
            String ge = st.nextToken();
            String bd = st.nextToken();
            String bd1 = st.nextToken();
            String bd2 = st.nextToken();
            String bd3 = st.nextToken();
            String crs = st.nextToken();
            String yrl = st.nextToken();
         
            int day = 0;
            int month = 0;
            int year = 0;
               
               //System.out.println(ln+fn+idno+ge+" - "+bd1+" - "+crs+yrl+day+month+year);
            StringTokenizer bdd = new StringTokenizer(bd1, "Birthdate:Age/ ");
            year = Integer.parseInt(bdd.nextToken());
            month = Integer.parseInt(bdd.nextToken());
            day = Integer.parseInt(bdd.nextToken());
            Student student = new Student(ln,fn, new Birthdate(day, month, year), ge.charAt(0), Integer.parseInt(Character.toString(yrl.charAt(1))), crs,Integer.parseInt(Character.toString(idno_s.charAt(1))));
               
            fileContent += ln+"|"+fn+" :"+day+"/"+month+"/"+"/"+year+":" +ge.charAt(1)+ ":"+yrl+":" +crs + ":" + idno_s+"*\n";
         }
      } catch (Exception ex) {
         JOptionPane.showMessageDialog(null, "Error saving the data");
         System.out.println(ex);
      }
      try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("student_data.txt"))) {
           bufferedWriter.write(fileContent);
           bufferedWriter.close();
      }catch (IOException e) {
           // Cxception handling
      }finally{
         _crypt.read("student_data.txt");
         _crypt.encrypt();
         _crypt.write(_crypt.encryptResult(),"student_data_en","txt");
      }
   }
   //load the student_data.txt and store it in student_list
   public void load(){
      try(BufferedReader bufferedReader = new BufferedReader(new FileReader("student_data.txt"))) {
         CryptoCode _crypt = new  CryptoCode(2);//
         _crypt.read("student_data.txt");
         _crypt.decrypt(4);
         String line = bufferedReader.readLine();
         while(line != null) {
            StringTokenizer content = new StringTokenizer(line,"/:|");
            Student student = new Student(content.nextToken(),content.nextToken(),new Birthdate(Integer.parseInt(content.nextToken()),Integer.parseInt(content.nextToken()),Integer.parseInt(content.nextToken())),content.nextToken().charAt(0),Integer.parseInt(Character.toString(content.nextToken().charAt(1))),content.nextToken(),0);
            stored_id = Integer.parseInt(Character.toString(content.nextToken().charAt(1)));
            student.setIdNumber(stored_id);
         
            line = bufferedReader.readLine();
            student_list.add(student);
         }
         bufferedReader.close();
      } catch (FileNotFoundException e) {
         // Exception handling \ if file not found, this will catch the exception
      } catch (IOException e) {
         // Exception handling
      }finally{
         idno = 1;
         String contents = student_list.toString();
         String[] list = contents.split("~");
         int size = list.length;
         int traverse = 0;
         for(String a: list){
            if(size <= 5){
               if(traverse == 0)
                  lblresult1.setText(list[traverse]);
               if(traverse == 1)
                  lblresult2.setText(list[traverse]);
               if(traverse == 2)
                  lblresult3.setText(list[traverse]);
               if(traverse == 3)
                  lblresult4.setText(list[traverse]);
               if(traverse == 4)
                  lblresult5.setText(list[traverse]);
               traverse++;
            }else{
               lblresult1.setText(list[size-5]);
               lblresult2.setText(list[size-4]);
               lblresult3.setText(list[size-3]);
               lblresult4.setText(list[size-2]);
               lblresult5.setText(list[size-1]);
            }
               
         }
            //increment id to avoid duplication 
         idno = (stored_id<idno)?idno:stored_id; //<- if the last stored data consist of idnumber 5, the new student added will have idnumber 6
      }
   }
   
   public static void main(String... args){
      new StudentManagement();
   }//end of main
}//end of class
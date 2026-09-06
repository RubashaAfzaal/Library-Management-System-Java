import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class Admin{
    private String adminId;
    private String username;
    private String password;
    public Admin(String adminId,String username,String password){
        this.adminId= adminId;
        this.username= username;
        this.password= password;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void saveToFile(){
        try{
            FileWriter writer = new FileWriter("admins.txt",true);
            writer.write(adminId + ","+ username + ","+ password + " \n");
writer.close();
System.out.println("Admin successfully saved.");
        }
    
        catch(Exception e){
            System.out.println("Error saving admin data.");
        }
    }
        public static boolean verifyLogin(String inputUsername, String inputPassword){
           if(inputUsername.equalsIgnoreCase("admin") && inputPassword.equals("1234")){
                    return true;
                }
                File file = new File("admins.txt");
                if(file.exists()){
                 try{
               Scanner reader= new Scanner(file);
                while(reader.hasNextLine()){
                    String line=reader.nextLine().trim();
                    if (line.isEmpty()) continue;
                    String[] parts = line.split(",");
                    if (parts.length >=3){
                    String storedUser=parts[1].trim();
                    String storedPass=parts[2].trim();
                    if(storedUser.equalsIgnoreCase(inputUsername) && storedPass.equals(inputPassword)){
                        reader.close();
                        return true;
                    }
                }
              }
              reader.close();
                 }
                  catch(Exception e){
                System.out.println("Error in reading admin file.");
        
        }

           }
           return false;
        }
}

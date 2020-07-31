import java.util.UUID;
import java.util.Scanner;

public class Email {
    private Department department;
    private String adress;
    private String alternateAdress = "";
    private String company;
    private String password;
    private int capacity = 10;
    private String firstName;
    private String lastName;

    Email(String firstName, String lastName, Department department, String company){
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.department = department;
        this.adress = generateAdress();
        this.password = generatePassword();
    }

    private String generateAdress(){
        return String.format("%1$s.%2$s@%3$s.%4$s.com", firstName, lastName, department, company);
    }

    private String generatePassword(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public boolean changePassword(String currentPassword){
        if (currentPassword != this.password){
            return false;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the new password");
        String str = sc.nextLine();
        sc.close();
        this.password = str;
        return true;
    }

    public void setAlternateadress(String altAdress){
        alternateAdress = altAdress;
    }

    private void setCapacity(int c){
        this.capacity = c;
    }

    public int getCapacity(){
        return capacity;
    }

    public String getadress(){
        return adress;
    }

    public String getName(){
        return firstName + " " + lastName;
    }

    public String getPassword(){
        return password;
    }

}
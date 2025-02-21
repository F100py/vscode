package Unit0.School;
public class Student {
    private int id;
    private String Name;
    private int Grade;

    public Student(int id, String Name, int Grade){
        this.id = id;
        this.Name = Name;
        this.Grade = Grade;
    }
    public int getid(){return id;}
    public String getName(){return Name;}
    public int getGrade(){return Grade;}

    public void multid(int by){
        this.id = id*by;
    }

    public boolean isValid(){
        if (id>0&&Name!=null&&Name.length()>0&&Grade>=9&&Grade<=12)
            return true;
        else
            return false;
        
    }

    public String toString(){
        return "id: "+getid() + ", Name: " + getName() + ", grade: " + getGrade();
    }
}
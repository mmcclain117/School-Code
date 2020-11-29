
public class President {

    public String lastName;
    public String firstName;
    public String midName;
    public int orderNum;
    public String homeState;

    public President(String x[]) {
// ID,Last Name,First Name,Middle Name,Order of Presidency,Date of Birth,Date of Death,Town or County of Birth,State of Birth,Home State,Party Affiliation,Date Took Office,Date Left Office,Assassination Attempt,Assassinated,Religious Affiliation,Image Path
        lastName = x[1];
        firstName = x[2];
        midName = x[3];
        orderNum = Integer.parseInt(x[4]);
        homeState = x[9];
    }

    public String last() {
        return lastName;
    }

    public String first() {
        return firstName;
    }

    public String mid() {
        return midName;
    }

    public int order() {
        return orderNum;
    }

    public String home() {
        return homeState;
    }

    public String toStr() {
        return firstName + " " + midName + " " + lastName + " " + orderNum + " " + homeState;
    }

    public int compare() {
        return;
    }
}

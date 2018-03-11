package defining_classes.Problem09;

/**
 * Created by Chilly on 26.10.2017 г..
 */
public class FamilyMember {
    private String familyMemberName;
    private String familyMemberBirthday;

    public FamilyMember(String familyMemberName, String familyMemberBirthday) {
        this.familyMemberName = familyMemberName;
        this.familyMemberBirthday = familyMemberBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.familyMemberName, this.familyMemberBirthday);
    }
}
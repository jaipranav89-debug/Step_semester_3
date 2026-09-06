package AccessModifiers.assignment_problems;

class LibraryMemberBean {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    public LibraryMemberBean() {
    }

    String getMembershipId() {
        return membershipId;
    }

    void setMembershipId(String id) {
        if (membershipId == null) {
            membershipId = id;
        }
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    boolean isPremiumMember() {
        return premiumMember;
    }

    void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    void setSecurityAnswer(String answer) {
        securityAnswer = answer.length() + "_" + answer;
    }

    public static void main(String[] args) {
        LibraryMemberBean m = new LibraryMemberBean();

        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);

        System.out.println(m.getMembershipId());
        System.out.println(m.isPremiumMember());

        m.setMembershipId("FAKE-0000");

        System.out.println(m.getMembershipId());

        m.setSecurityAnswer("BlueMountain");
    }
}
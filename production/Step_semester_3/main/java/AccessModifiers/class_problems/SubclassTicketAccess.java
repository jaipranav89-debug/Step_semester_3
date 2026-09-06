package AccessModifiers.class_problems;

class SubclassTicketAccess {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        if (accessorContext.equals("SAME_CLASS"))
            return "ALLOWED";

        if (fieldModifier.equals("private"))
            return "DENIED";

        if (fieldModifier.equals("default")) {
            if (accessorContext.equals("SAME_PACKAGE"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        if (fieldModifier.equals("protected")) {
            if (accessorContext.equals("SAME_PACKAGE") ||
                    accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        return "ALLOWED";
    }

    public static void main(String[] args) {
        System.out.println(
                classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")
        );

        System.out.println(
                classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")
        );
    }
}
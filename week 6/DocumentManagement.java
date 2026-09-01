interface Confidential {
    // Tagging interface - no methods
}

class PublicDocument {
    String name;

    PublicDocument(String name) {
        this.name = name;
    }
}

class FinancialDocument implements Confidential {
    String name;

    FinancialDocument(String name) {
        this.name = name;
    }
}

class PersonalDocument implements Confidential {
    String name;

    PersonalDocument(String name) {
        this.name = name;
    }
}

public class DocumentManagement {
    public static void main(String[] args) {

        Object[] documents = {
            new PublicDocument("Company Brochure"),
            new FinancialDocument("Salary Report"),
            new PersonalDocument("Personal Records")
        };

        for (Object document : documents) {
            if (document instanceof Confidential) {
                System.out.println(document.getClass().getSimpleName()
                        + " is a confidential document.");
            } else {
                System.out.println(document.getClass().getSimpleName()
                        + " is not a confidential document.");
            }
        }
    }
}
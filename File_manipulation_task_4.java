package calc;
import java.util.*;


public class File_manipulation_task_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Notes\nHave Happy Notes to have Happy Memories");

        boolean process = true;
        String title;
        ArrayList<Object> notes = new ArrayList<>(); 

        while (process) {
            System.out.println("Press\n 1 - create new notes\n 2 - add existing notes\n 3 - delete notes\n 4 - Display notes");
            int number = scan.nextInt();
            scan.nextLine(); 
            boolean check = true;

            if (number == 1) {
                Notes_Management n = new Notes_Management();
                System.out.println("Enter the headline of your Note");

                while (check) {
                    boolean exist_title = true;
                    title = scan.nextLine(); 
                    if (title.trim().equals("")) {                // To checck whether the name is already exsist
                        System.out.println("Sir Please Enter Title — it should not be empty");
                        continue;
                    } else {
                        for (int i = 0; i < notes.size(); i++) {
                            if (((Notes_Management) notes.get(i)).getTitle().equals(title)) { 
                                exist_title = false;
                                System.out.println("This Title already exists. Please enter a new Title");
                                break;
                            }
                        }
                        if (exist_title) {
                            n.setTitle(title);
                            check = false;
                        }
                    }
                }

                System.out.println("Enter content of the notes here");
                String content = scan.nextLine(); 
                n.setContent(content + " ");                // empty space when you add 
                notes.add(n); 
            }

            else if (number == 2) {
                System.out.println("Enter the Note title:");
                title = scan.nextLine();
                boolean found = false;

                for (int i = 0; i < notes.size(); i++) {
                    Notes_Management existing = (Notes_Management) notes.get(i);
                    if (existing.getTitle().equals(title)) {
                        System.out.println("You can write your notes now");
                        String content = scan.nextLine();
                        existing.setContent(existing.getContent() + " " + content); 
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("This title does not exist. Please give a correct one.");
                }
            }

            else if (number == 3) {
                System.out.println("Enter the title to remove the Note:");
                title = scan.nextLine();
                boolean removed = false;

                for (int i = 0; i < notes.size(); i++) {
                    if (((Notes_Management) notes.get(i)).getTitle().equals(title)) {
                        notes.remove(i);
                        System.out.println("Note removed successfully.");
                        removed = true;
                        break;
                    }
                }

                if (!removed) {
                    System.out.println("This title does not exist.");
                }
            }

            else if (number == 4) {
                System.out.println("Enter 1 to get specific Notes\nEnter 2 to get All Notes");
                int valid = scan.nextInt();
                scan.nextLine(); 

                if (valid == 1) {
                    System.out.println("Enter the title to Display");
                    title = scan.nextLine();
                    for (Object note : notes) {
                        Notes_Management nm = (Notes_Management) note;
                        if (nm.getTitle().equals(title)) {
                            System.out.println("Title is : " + nm.getTitle());
                            String[] words = nm.getContent().split(" ");
                            int count = 0;
                            for (String word : words) {
                                System.out.print(word + " ");
                                count++;
                                if (count == 20) {
                                    System.out.println();
                                    count = 0;
                                }
                            }
                            System.out.println();
                        }
                    }
                }

                else if (valid == 2) {
                    for (int j = 0; j < notes.size(); j++) {
                        Notes_Management nm = (Notes_Management) notes.get(j);
                        System.out.println("Note number : " + (j + 1));
                        System.out.println("Title is : " + nm.getTitle());
                        String[] words = nm.getContent().split(" ");
                        int count = 0;
                        for (String word : words) {
                            System.out.print(word + " ");
                            count++;
                            if (count == 20) {
                                System.out.println();
                                count = 0;
                            }
                        }
                        System.out.println("\n");
                    }
                }
            }

            System.out.println("If you want to continue Press \"YES\" Otherwise Press \"NO\"");
            String further = scan.nextLine();
            if (!further.equalsIgnoreCase("YES")) {
                process = false;
            }
        }
    }
}
     //1 create new notes
	 //2 add in existing notes 
	 // 3 delete existing notes
	 //4 display existing notes

class Notes_Management {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content == null ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


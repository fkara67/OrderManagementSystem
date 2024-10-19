package core;

import javax.swing.*;

public class Helper {

    public static void setTheme() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (info.getName().equals("Nimbus")) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldListEmpty(JTextField[] fields) {
        for (JTextField field : fields) {
            if (isFieldEmpty(field)) return true;
        }
        return false;
    }

    public static boolean isEmailValid(String mail) {
        if (mail == null || mail.trim().isEmpty()) return false;

        if (!mail.contains("@")) return false;

        String[] parts = mail.split("@");
        if (parts.length != 2) return false;

        if (parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) return false;

//        if (!parts[1].contains(".")) return false;
//
//        if (parts[1].split("\\.").length < 2) return false;

        return true;
    }

    public static void optionPaneDialogTR() {
        UIManager.put("OptionPane.okButtonText","Tamam");
    }

    public static void showMsg(String message) {
        String msg;
        String title;

        //optionPaneDialogTR();
        switch (message) {
            case "fill":
                msg = "Please, fill all fields!";
                title = "ERROR";
                break;
            case "done":
                msg = "Process is successfull";
                title = "RESULT";
                break;
            case "error":
                msg = "An Error occurred!!!";
                title = "ERROR";
                break;
            default:
                msg = message;
                title = "Message";
        }
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }
}